package cn.fgliu.demo.ui;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AlphabetIndexer;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.fgliu.demo.R;
import cn.fgliu.demo.adapt.ContactAdapter;
import cn.fgliu.demo.entity.Contact;

public class ContactActivity extends Activity {

    /**
     * 分组的布局
     */
    private LinearLayout titleLayout;

    /**
     * 弹出式分组的布局
     */
    private RelativeLayout sectionToastLayout;

    /**
     * 右侧可滑动字母表
     */
    private Button alphabetButton;

    /**
     * 分组上显示的字母
     */
    private TextView title;

    /**
     * 弹出式分组上的文字
     */
    private TextView sectionToastText;


    /**
     * 联系人ListView
     */
    private ListView contactsListView;

    /**
     * 联系人列表适配器
     */
    private ContactAdapter adapter;

    /**
     * 用于进行字母表分组
     */
    private AlphabetIndexer indexer;

    /**
     * 存储所有手机中的联系人
     */
    private List<Contact> contacts = new ArrayList<Contact>();

    /**
     * 定义字母表的排序规则
     */
    private String alphabet = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 上次第一个可见元素，用于滚动时记录标识。
     */
    private int lastFirstVisibleItem = -1;

    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        adapter = new ContactAdapter(this, R.layout.contact_item, contacts);
        sectionToastLayout = (RelativeLayout) findViewById(R.id.section_toast_layout);
        titleLayout = (LinearLayout) findViewById(R.id.title_layout);
        title = (TextView) findViewById(R.id.title);
        sectionToastText = (TextView) findViewById(R.id.section_toast_text);
        alphabetButton = (Button) findViewById(R.id.alphabetButton);
        contactsListView = (ListView) findViewById(R.id.contacts_list_view);

        int permissionCheck = ContextCompat.checkSelfPermission(ContactActivity.this.getApplicationContext(),
                Manifest.permission.WRITE_CALENDAR);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) { //检查是否有权限
            Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
            String SORT_KTY="sort_key";
            if(android.os.Build.VERSION.SDK_INT>=19){
                SORT_KTY="phonebook_label";
            }
            Cursor cursor = getContentResolver().query(uri,
                    new String[]{"display_name", SORT_KTY}, null, null, "sort_key");
            if (cursor.moveToFirst()) {
                do {
                    String name = cursor.getString(0);
                    String sortKey = getSortKey(cursor.getString(1));
                    Contact contact = new Contact();
                    contact.setName(name);
                    contact.setSortKey(sortKey);
                    contacts.add(contact);
                } while (cursor.moveToNext());
            }
            startManagingCursor(cursor);
            indexer = new AlphabetIndexer(cursor, 1, alphabet);
            adapter.setIndexer(indexer);
            if (contacts.size() > 0) {
                setupContactsListView();
                setAlpabetListener();
            }
        } else { // 如果没有权限，则发起权限请求

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(ContactActivity.this,
                    Manifest.permission.READ_CONTACTS)) {
                Toast.makeText(this, "Deleted Successfully!", Toast.LENGTH_LONG).show();
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(ContactActivity.this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        PERMISSIONS_REQUEST_READ_CONTACTS);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    /**
     * 为联系人ListView设置监听事件，根据当前的滑动状态来改变分组的显示位置，从而实现挤压动画的效果。
     */
    private void setupContactsListView() {
        contactsListView.setAdapter(adapter);
        contactsListView.setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                                 int totalItemCount) {
                int section = indexer.getSectionForPosition(firstVisibleItem);
                int nextSecPosition = indexer.getPositionForSection(section + 1);
                if (firstVisibleItem != lastFirstVisibleItem) {
                    MarginLayoutParams params = (MarginLayoutParams) titleLayout.getLayoutParams();
                    params.topMargin = 0;
                    titleLayout.setLayoutParams(params);
                    title.setText(String.valueOf(alphabet.charAt(section)));
                }
                if (nextSecPosition == firstVisibleItem + 1) {
                    View childView = view.getChildAt(0);
                    if (childView != null) {
                        int titleHeight = titleLayout.getHeight();
                        int bottom = childView.getBottom();
                        MarginLayoutParams params = (MarginLayoutParams) titleLayout
                                .getLayoutParams();
                        if (bottom < titleHeight) {
                            float pushedDistance = bottom - titleHeight;
                            params.topMargin = (int) pushedDistance;
                            titleLayout.setLayoutParams(params);
                        } else {
                            if (params.topMargin != 0) {
                                params.topMargin = 0;
                                titleLayout.setLayoutParams(params);
                            }
                        }
                    }
                }
                lastFirstVisibleItem = firstVisibleItem;
            }
        });

    }

    /**
     * 获取sort key的首个字符，如果是英文字母就直接返回，否则返回#。
     *
     * @param sortKeyString 数据库中读取出的sort key
     * @return 英文字母或者#
     */
    private String getSortKey(String sortKeyString) {
        String key = sortKeyString.substring(0, 1).toUpperCase();
        if (key.matches("[A-Z]")) {
            return key;
        }
        return "#";
    }


    private void setAlpabetListener() {
        alphabetButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float alphabetHeight = alphabetButton.getHeight();
                float y = event.getY();
                int sectionPosition = (int) ((y / alphabetHeight) / (1f / 27f));
                if (sectionPosition < 0) {
                    sectionPosition = 0;
                } else if (sectionPosition > 26) {
                    sectionPosition = 26;
                }
                String sectionLetter = String.valueOf(alphabet.charAt(sectionPosition));
                int position = indexer.getPositionForSection(sectionPosition);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        alphabetButton.setBackgroundResource(R.drawable.a_z_click);
                        sectionToastLayout.setVisibility(View.VISIBLE);
                        sectionToastText.setText(sectionLetter);
                        contactsListView.setSelection(position);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        sectionToastText.setText(sectionLetter);
                        contactsListView.setSelection(position);
                        break;
                    default:
                        alphabetButton.setBackgroundResource(R.drawable.a_z);
                        sectionToastLayout.setVisibility(View.GONE);
                }
                return true;
            }
        });
    }


    // 权限请求后的回调
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_READ_CONTACTS: {
                // 如果授权不通过，则返回结果值为空
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "grantResults have something!", Toast.LENGTH_LONG).show();
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                    //如果android操作系统版本4.4或4.4以上就要用phonebook_label而不是sort_key字段
                    String SORT_KTY="sort_key";
                    if(android.os.Build.VERSION.SDK_INT>=19){
                        SORT_KTY="phonebook_label";
                    }

                    Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                    Cursor cursor = getContentResolver().query(uri,
                            new String[]{"display_name", SORT_KTY}, null, null, "sort_key");
                    if (cursor.moveToFirst()) {
                        do {
                            String name = cursor.getString(0);
                            String sortKey = getSortKey(cursor.getString(1));
                            Contact contact = new Contact();
                            contact.setName(name);
                            contact.setSortKey(sortKey);
                            contacts.add(contact);
                        } while (cursor.moveToNext());
                    }
                    startManagingCursor(cursor);
                    indexer = new AlphabetIndexer(cursor, 1, alphabet);
                    adapter.setIndexer(indexer);
                    if (contacts.size() > 0) {
                        setupContactsListView();
                        setAlpabetListener();
                    }

                } else {
                    Toast.makeText(this, "grantResults'length is empty!", Toast.LENGTH_LONG).show();
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

}

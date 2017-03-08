package cn.fgliu.demo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import cn.fgliu.demo.R;
import cn.fgliu.demo.entity.Book;

public class EntitySendActivity extends Activity implements OnClickListener {

    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entity_send);
        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Book book = new Book();
        book.setBookName("Android¸ß¼¶±à³Ì");
        book.setAuthor("Reto Meier");
        book.setPages(398);
        book.setPrice(59.00);
        URL url = null;
        ObjectOutputStream oos = null;
        try {
            url = new URL("http://120.0.0.1:8080/ServerTest/servlet/TestServlet");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);
            connection.setRequestMethod("POST");
            oos = new ObjectOutputStream(connection.getOutputStream());
            oos.writeObject(book);
            InputStreamReader read = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(read);
            String line = "";
            while ((line = br.readLine()) != null) {
                Log.d("TAG", "line is " + line);
            }
            br.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}



//import java.io.IOException;
//        import java.io.ObjectInputStream;
//        import java.io.PrintWriter;
//
//        import javax.servlet.ServletException;
//        import javax.servlet.http.HttpServlet;
//        import javax.servlet.http.HttpServletRequest;
//        import javax.servlet.http.HttpServletResponse;
//
//public class TestServlet extends HttpServlet {
//
//    public void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        ObjectInputStream ois = null;
//        try {
//            ois = new ObjectInputStream(request.getInputStream());
//            Book book = (Book) ois.readObject();
//            System.out.println("ÊéÃûÊÇ£º " + book.getBookName());
//            System.out.println("×÷ÕßÊÇ£º " + book.getAuthor());
//            System.out.println("¼Û¸ñÊÇ£º " + book.getPrice());
//            System.out.println("Ò³ÊýÊÇ£º " + book.getPages());
//            PrintWriter out = response.getWriter();
//            out.print("success");
//            out.flush();
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            ois.close();
//        }
//    }
//
//}
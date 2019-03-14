package tests;
import java.io.File;
import java.io.FileInputStream;

import static helpers.Utilities.*;

import java.net.URL;
import java.util.*;

public class Demo extends BaseTest {


  public static void main(String[] args) throws Exception {
    Demo pro = new Demo();
    pro.getProp();
  }

  public void getProp() throws Exception {
    String email;
    FileInputStream in;
    Properties prop = new Properties();
    URL url = getClass().getResource("app.properties");
    File propFile = new File(url.getPath());
    System.out.println(propFile);
    in = new FileInputStream(propFile);
    prop.load(in);

    email = prop.getProperty("mail");
    System.out.println(email);
  }
}

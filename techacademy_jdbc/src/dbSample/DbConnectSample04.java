package dbSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;

import javax.xml.crypto.dsig.keyinfo.KeyInfo;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnectSample04 {

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. ドライバーのクラスをJava上で読み込む
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. DBと接続する
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/world?useSSL=false&allowPublicKeyRetrieval=true",
                    "root", 
                    "_Sakurai0125");
            
            String sql = "SELECT * FROM country WHERE Name = ?";

            // 3. DBとやり取りする窓口(Statementオブジェクト)の作成
            pstmt = con.prepareStatement(sql);

            // 4, 5. Select分の実行と結果を格納/代入
            System.out.print("検索キーワードを入力してください > ");
            String input = keyIn();
            
            
             pstmt.setString(1, input);
            
            
            rs = pstmt.executeQuery();

            // 6. 結果を表示する
            while(rs.next()) {
                //Name列の値を取得
                String name = rs.getString("Name");
                //Population列の値を取得 ←追記
                int population = rs.getInt("Population");
                //取得した値を表示
                System.out.println(name);
                System.out.println(population);
            }
            
            //6-1. データの更新を行う
            /*
            sql = "update country set Population = 105000 where Code = 'ABW'";
            int count = stmt.executeUpdate(sql);
            System.out.println(count); */

        } catch (ClassNotFoundException e) {
            System.err.println("JDBSドライバーのロードに失敗しました。");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("データベースに異常が発生しました。");
            e.printStackTrace();
        } finally {
            // 7. 接続を閉じる
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.err.println("ResultSetを閉じるときにエラーが発生しました。");
                    e.printStackTrace();
                }
            }
            if (pstmt!= null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.err.println("Statementを閉じるときにエラーが発生しました。");
                    e.printStackTrace();
                }
            }
            
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("データベース切断時にエラーが発生しました。");
                    e.printStackTrace();
                }
            }
          }  
        }

    private static String keyIn() {
        String line = null;
        try {
            BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
            line = key.readLine();
        } catch (IOException e) {
           
        }
        return line;
    }
    }



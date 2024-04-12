package dbSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectSample01 {

    public static void main(String[] args) {
        
        try {
            //1. ドライバーのクラスをJava上で読み込む
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2. DBと接続する
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/world?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "_Sakurai0125"
                    );
            
            //3. DBとやり取りする窓口(Statementオブジェクト)の作成
            
            //4, 5. Select分の実行と結果を格納/代入
            
            //6. 結果を表示する
            
            
        } catch (ClassNotFoundException e) {
            System.err.println("JDBSドライバーのロードに失敗しました。");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("データベースに異常が発生しました。");
            e.printStackTrace();
        }
        
            //7. 接続を閉じる

    }

}

package aa;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Mysql mysql=new Mysql();
        Redis redis=new Redis();
        ResultSet rs=null;

        String type="管理员";

        String sql="select * from login where type ='"+type+"'";

        String username;

        if(redis.hexists("user_"+type, "username_")){

                 username=redis.hget("user_"+type, "username_");

                 System.out.println("Welcome Redis! User "+username+" login success");

        }else{

                 rs=mysql.conn.createStatement().executeQuery(sql);

                 if(rs.next()==false){

                          System.out.println("Mysql no register, Please register first");

                 }else{

                          username=rs.getString("type");

                          System.out.println("Welcome Mysql ! User "+username+" login success");

                          redis.hset("user_"+type, "username_", username);



                          redis.expire("user_"+type, 60);

                 }

        }
        
	}

}

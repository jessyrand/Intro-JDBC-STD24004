import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("Connexion réussie !");

            List<User> users = new ArrayList<>();

            Statement st = conn.createStatement();

            String sql = "SELECT id, name FROM \"user\"";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                users.add(new User(id, name));
            }

            for (User user : users) {
                System.out.println(user);
            }

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}

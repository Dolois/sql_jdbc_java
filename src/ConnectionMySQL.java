import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionMySQL
{
	public void recupererMesDonnes()
	{
		String url = "jdbc:mysql://localhost/formation";
		String user = "root";
		String pwd= "Dauphyn1";
				
		Connection cn = null;
		Statement st = null;
			
		// connexion avec le driver
		try 
		{
			// chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Ok !");

			// récupération de la connexion
			cn = DriverManager.getConnection(url, user, pwd);
				
			// création d'un statement
			st = cn.createStatement();
				
			String sql =	"SELECT * FROM bibliotheque_db.livre\r\n" + 
							"INNER JOIN bibliotheque_db.auteur\r\n" + 
							"WHERE id_auteur = ref_auteur\r\n" + 
							"AND id_auteur = 4;";
					
			// exécution requete
			ResultSet result = st.executeQuery(sql);
					
			int id_livre;
			String titre;
			int ref_auteur;
			String editeur;
			String dateEdition;
			int id_auteur;
			String nom;
			int age;
					
			while (result.next())
			{
				// récupérer l'id_livre
				id_livre = result.getInt("id_livre");
					
				// récupérer le titre
				titre = result.getString("titre");
						
				// récupérer le ref_auteur
				ref_auteur = result.getInt("ref_auteur");
						
				// récupérer l'editeur
				editeur = result.getString("editeur");
				
				// récupérer la dateEdition
				dateEdition = result.getString("dateEdition");
				
				// récupérer le id_auteur
				id_auteur = result.getInt("id_auteur");
				
				// récupérer le nom
				nom = result.getString("nom");
				
				// récupérer l'age
				age = result.getInt("age");
				
				System.out.println(id_livre + " > " + titre + " " + ref_auteur + " " +
									editeur + " " + dateEdition + " " + id_auteur + " " +
									nom + " " + " " + age);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				cn.close();
				st.close();
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
	
	
	public static void main(String[] args)
	{
		// Connexion avec le server mySQL
		ConnectionMySQL c = new ConnectionMySQL();
		c.recupererMesDonnes();
	}
}

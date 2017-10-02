package quiz.start.repository;

/*
 *  Aðalsteinn Ingi Pálsson
 *  aip7@hi.is
 *
 *  Geir Garðarsson
 *  geg42@hi.is
 *
 *  Daníel Guðnason
 *  dag**@hi.is
 *
 *  Fannar Gauti Guðmundsson
 *  *@hi.is
 */

import quiz.start.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/*
    A java class that collects the users, just like an repository
*/
public class UserCollection {

    private ArrayList<User> collection = new ArrayList<User>();

    //one user at the moment but will be an array of Users
    public User current_user;
    public SQLUser sqlUser;

    /*
    constructor
    */
    public UserCollection() throws SQLException {
        sqlUser = new SQLUser();

        try {
            updateCollection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Iterator<User> collectionIterator = collection.iterator();
        while (collectionIterator.hasNext()) {
            System.out.println(collectionIterator.next().getName());
        }

        System.out.println(collection.size());
    }

    /*
     * @param User
     * Function to add a new user to the database, the updates,
     * the userCollection
     */
    public void addUser(User u) throws ClassNotFoundException, SQLException {

        sqlUser.newUser(u.getName(), u.getPass(), u.getEmail(), 0, u.getLocation());
        updateCollection();
    }

    /*
     * @param User
     * Function to delete a user from the database, then updates
     * the userCollection
     */
    public void deleteUser(User newuser) throws ClassNotFoundException {
        current_user = newuser;
        sqlUser.deleteUser(current_user.getName(),current_user.getPass(),current_user.getEmail());
    }


    /*
     * @param String
     * @param String
     * Function to get a single user from the userCollection, if the
     * user exists and the password is right
     *
     * @return User
     */
    public User getUser(String userName, String passW) throws Exception {

        User tmp = new User(null,null,null,0,0,null, false);

        Iterator<User> collectionIterator = collection.iterator();
        while (collectionIterator.hasNext()) {

            User u = collectionIterator.next();

            if (u.getName().equals(userName) && u.getPass().equals(passW)) {
                tmp = u;
                break;
            }
        }

        if (tmp.getName() == null) {
            throw new Exception("login error");
        }

        return tmp;
    }

    /*
     * Function to initialize and update the usercollection,
     * gets all the users' data from the database.
     */
    private void updateCollection() throws SQLException {
        ResultSet rs = sqlUser.extractAllUsers();

        try {

            //Process the resultset, put results
            //in a arraylist
            while (rs.next()) {

                User tmp = new User(rs.getString("Name"),
                        rs.getString("Pass"),
                        rs.getString("Email"),
                        0,
                        rs.getInt("Score"),
                        rs.getString("Location"),
                        false
                );

                collection.add(tmp);

            }

        } catch (SQLException e) {
            System.out.println("in updateCollection");
            System.out.println(e);
        }

    }

    /*
     * @param String
     * Checks if a username is taken
     *
     * @return boolean
     */
    public boolean validateUser(String potentialUser) {

        Iterator<User> collectionIterator = collection.iterator();
        while (collectionIterator.hasNext()) {
            String uName = collectionIterator.next().getName();

            if (uName.equals(potentialUser)) {
                return false;
            }
        }
        return true;
    }

}

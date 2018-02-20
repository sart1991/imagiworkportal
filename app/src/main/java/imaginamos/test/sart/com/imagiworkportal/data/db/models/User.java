package imaginamos.test.sart.com.imagiworkportal.data.db.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by SergioAlejandro on 20/02/2018.
 */

@Entity(tableName = "users", indices = {
        @Index(value = "username", name = "idx_username", unique = true),
        @Index(value = "email", name = "idx_email", unique = true),
})
public class User {

    @PrimaryKey
    @NonNull
    private String id = "temp";
    private String username;
    private String email;
    private String name;
    private String password;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getUsername ()
    {
        return username;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }


    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof User && this.id.equals(((User)obj).id);
    }
}

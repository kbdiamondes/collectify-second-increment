package com.capstone.kuhako.models;

import javax.persistence.*;

// Marks this java object as a representation of an entity/record from the database table "post"

@Entity
// Designate the table name related to the model
@Table(name = "posts")
public class Post{
    // Properties
    // Indicates the primary key

    @Id
    // id will be auto-incremented.
    @GeneratedValue
    private Long id;//AUTOGENERATED NOT required to CALL IN THE CONSTRUCTOR

    // Class properties that represents table column in a relational database are annotated as @Column
    @Column
    private String title;
    @Column
    private String content;

    // Establishes the relationship of the property to the "post" model
    @ManyToOne
    // Sets the relationship to this property and user_id column in the database to the primary key of the user model.
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    // Constructor
    // Default constructors are required when retrieving from the database.
    public Post() {
    }

    public Post( String title, String content) {
        this.title = title;
        this.content = content;
    }
    // Getter and Setter

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user=user;
    }

}

package com.Boonprakob.Thanaphon.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentOfThanaphon
{
    @Id
    private String id;
    private String name;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}

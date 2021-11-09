package com.example.M06UF2.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "file")

public class File {
    @Id
    public UUID fileid;

    public String contenttype;
    public byte[] data;
}

package me.renedo.naizfit.testers.domain;

import java.net.URL;
import java.util.UUID;

public class Brand {

    private final UUID id;

    private final Name name;

    private final URL logo;

    public Brand(UUID id, Name name, URL logo) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        verify();
    }

    private void verify() {
        if(id == null) {
            throw new BrandWithOutIdException();
        }
    }

    public UUID getId() {
        return id;
    }

    public URL getLogo() {
        return logo;
    }

    public Name getName() {
        return name;
    }
}

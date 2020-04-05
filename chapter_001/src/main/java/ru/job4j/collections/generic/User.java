package ru.job4j.collections.generic;

/**
 * job4j_design ru.job4j.collections.generic.User
 *
 * @author romanvohmin
 * @version 1
 * @since 05.04.2020 06:47
 */
public class User extends Base {

    protected User(String id) {
        super(id);
    }

    public String getId() {
        return super.getId();
    }
}

package com.imagine.world.models;


import javax.servlet.http.Cookie;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tuan on 10/20/14.
 */
public class CookieList extends SearchableList<Cookie> {

    private static Comparator nameComparator = new Comparator<Cookie>() {
        @Override
        public int compare(Cookie o, Cookie o2) {
            return o.getName().compareTo(o2.getName());
        }
    };

    public CookieList(List<Cookie> cookies){
        this.addAll(cookies);
    }

    public Cookie getByname(String name){
        Cookie cookie = new Cookie(name,null);
        return this.get(cookie,nameComparator);
    }
}

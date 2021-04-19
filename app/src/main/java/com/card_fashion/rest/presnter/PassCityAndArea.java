package com.card_fashion.rest.presnter;

import com.card_fashion.rest.model.Area;
import com.card_fashion.rest.model.Category;
import com.card_fashion.rest.model.City;

public interface PassCityAndArea {
    void PassCity(City city);
    void PassArea(Area area);
    void PassCat(Category category);
}

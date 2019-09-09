package com.idwebapp.test;

import java.util.ArrayList;
import java.util.List;

public class ListaClass {

	List<Long> getLista1() {

		List<Long> lst = new ArrayList<>();
		lst.add(1l);
		lst.add(2l);
		lst.add(3l);
		lst.add(4l);
		lst.add(5l);
		lst.add(6l);
		lst.add(7l);
		lst.add(8l);
		lst.add(9l);
		lst.add(10l);

		return lst;
	}

	List<Long> getLista2() {

		List<Long> lst = new ArrayList<>();

		lst.add(5l);
		lst.add(6l);
		lst.add(7l);
		lst.add(8l);
		lst.add(9l);
		lst.add(10l);

		return lst;
	}

	List<Long> getLista3() {

		List<Long> lst = new ArrayList<>();
		lst.add(4l);
		lst.add(5l);
		lst.add(6l);
		lst.add(7l);

		return lst;
	}
}

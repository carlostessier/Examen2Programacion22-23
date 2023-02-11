package com.hogwartslegacy.modelo;

public interface AccionesMago {

    public boolean lanzarHechizo(Object objetivo, String hechizo);

    public boolean aprenderHechizo(Hechizo hechizo);

    public boolean olvidarHechizo(Hechizo hechizo);



}

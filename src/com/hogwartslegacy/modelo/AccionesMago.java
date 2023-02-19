package com.hogwartslegacy.modelo;
public interface AccionesMago {

    /**
     * Método que permite al mago lanzar un hechizo
     * @param objetivo el objetivo del hechizo
     * @param hechizo el hechizo a lanzar
     *
     * @return devuelve true si se ha lanzado con éxito el hechizo
     */
    boolean lanzarHechizo(Object objetivo, String hechizo);

    /**
     * Método que permite aprender un hechizo al mago
     * @param hechizo el hechizo a aprender
     *
     * @return devuelve true si se ha aprendido el hechizo
     */
    boolean aprenderHechizo(Hechizo hechizo);

    /**
     * Método que permite al mago olvidar un hechizo
     * @param hechizo  el hechizo a olvidar
     *
     * @return devuelve true si se ha olvidado el hechizo
     */
    boolean olvidarHechizo(Hechizo hechizo);



}

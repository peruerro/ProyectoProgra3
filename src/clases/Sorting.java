package clases;

import java.util.ArrayList;

import db.SelectData;

public class Sorting {

    /**
     * Generic Merge Sort using id number
     *
     * @param listaJug list to be sorted
     * @param Jugadores para ordenar
     * @return lista ordenada
     */
    public static <T extends I_Comparable<Jugador>> ArrayList<Jugador> mergeSortNum(ArrayList<Jugador> listaJug) {
        if (listaJug.size() == 1) return listaJug;
        else {
            ArrayList<Jugador> listLeft = new ArrayList<Jugador>(listaJug.subList(0, listaJug.size() / 2));
            ArrayList<Jugador> listRight = new ArrayList<Jugador>(listaJug.subList(listaJug.size() / 2, listaJug.size()));

            listLeft = mergeSortNum(listLeft);
            listRight = mergeSortNum(listRight);

            return mergeNum(listLeft, listRight);
        }}
        /**
         * Funcion merge para separar y ordenar por id
         *
         * @param a   left list
         * @param b   right list
         * @param Jugadores
         * @return lista separada y ordenada
         */
        public static <T extends I_Comparable<Jugador>> ArrayList<Jugador> mergeNum(ArrayList<Jugador> a, ArrayList<Jugador> b) {
            ArrayList<Jugador> c = new ArrayList<>();
            while (!a.isEmpty() && !b.isEmpty()) {
                if (a.get(0).equals(b.get(0))) {
                    c.add(b.get(0));
                    b.remove(0);
                } else {
                    c.add(a.get(0));
                    a.remove(0);
                }
            }
            //At this point either a or b is empty
            while (!a.isEmpty()) {
                c.add(a.get(0));
                a.remove(0);
            }
            while ((!b.isEmpty())) {
                c.add(b.get(0));
                b.remove(0);
            }
            return c;
        }
    	public static void main(String[] args) {
    		String lista="SELECT idJugador, nombre, edad, nacionalidad,pala, manoHabil, posicion, puntosRanking from Jugador order by puntosRanking desc limit 10";
    		ArrayList <Jugador> listaJug= SelectData.seleccionarJugador(lista);
    		
    		System.out.println(mergeSortNum(listaJug));
    		}
	

}

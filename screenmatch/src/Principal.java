import com.aluracursos.screenmatch.FiltroRecomendaciones;
import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula();
        miPelicula.setNombre ("Encanto");
        miPelicula.setFechaDeLanzamiento (2021);
        miPelicula.setDuracionEnMinutos (120);
        miPelicula.setIncluidoEnPlan(true);

        miPelicula.evalua(10);
        miPelicula.evalua(10);

        miPelicula.muestraFichaTecnica();
        // System.out.println(miPelicula.getTotalDeLasEvaluaciones());
//        System.out.println(miPelicula.sumaDeLasEvaluaciones);
//        System.out.println(miPelicula.totalDeLasEvaluaciones); // ya no funciona porque se ocultaron los atributos con "private"
//        System.out.println(miPelicula.calcularMedia());

Pelicula otraPelicula = new Pelicula();
        otraPelicula.setNombre("Matrix");
        otraPelicula.setFechaDeLanzamiento(1998);
        otraPelicula.setDuracionEnMinutos(180);


        Serie casaDragon = new Serie();
        casaDragon.setNombre("La casa del Dragón");
        casaDragon.setFechaDeLanzamiento(2022);
        casaDragon.setTemporada(1);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.muestraFichaTecnica();
        System.out.println("Tiempo estimado para completar la serie:"+ casaDragon.getDuracionEnMinutos() + " minutos");

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        calculadora.incluye(otraPelicula);
        System.out.println("Tiempo necesario para ver tus títulos favoritos estas vacaciones: " + calculadora.getTiempoTotal() + " minutos");

        FiltroRecomendaciones filtroRecomendaciones = new FiltroRecomendaciones();
        filtroRecomendaciones.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("La casa de Perla");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(50);

        filtroRecomendaciones.filtra(episodio);
    }
}

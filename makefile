MAIN = Main.java
DOMINIO = Dominio/ControladorDominio.java Dominio/ControladorHidato.java Dominio/ControladorPartida.java
ESTRUCTURAS = Dominio/Estructuras/Casilla.java Dominio/Estructuras/CasillaHidato.java Dominio/Estructuras/Tablero.java Dominio/Estructuras/TableroHidato.java Dominio/Estructuras/Usuario.java
PARTIDA = Dominio/Partida/Partida.java
TIEMPO = Dominio/Tiempo/Tiempo.java
PRESENTACION = Presentacion/ControladorPresentacion.java
PERSISTENCIA = Persistencia/ControladorPersistencia.java

MAIN2 = Main.class
DOMINIO2 = Dominio/ControladorDominio.class Dominio/ControladorHidato.class Dominio/ControladorPartida.class
ESTRUCTURAS2 = Dominio/Estructuras/Casilla.class Dominio/Estructuras/CasillaHidato.class Dominio/Estructuras/Tablero.class Dominio/Estructuras/TableroHidato.class Dominio/Estructuras/Usuario.class
PARTIDA2 = Dominio/Partida/Partida.class
TIEMPO2 = Dominio/Tiempo/Tiempo.class
PRESENTACION2 = Presentacion/ControladorPresentacion.class
PERSISTENCIA2 = Persistencia/ControladorPersistencia.class

0: 
	javac $(MAIN) $(DOMINIO) $(ESTRUCTURAS) $(PARTIDA) $(TIEMPO) $(PRESENTACION) $(PERSISTENCIA)

1:
	java Main

2:
	javac $(MAIN) $(DOMINIO) $(ESTRUCTURAS) $(PARTIDA) $(TIEMPO) $(PRESENTACION) $(PERSISTENCIA)
	java Main

clean:
	rm $(MAIN2) $(DOMINIO2) $(ESTRUCTURAS2) $(PARTIDA2) $(TIEMPO2) $(PRESENTACION2) $(PERSISTENCIA2)

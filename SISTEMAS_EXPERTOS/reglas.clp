
(import pe.edu.pucp.sistemasexpertos.proyecto.modelo.*)
(deftemplate Persona        (declare (from-class Persona)))
(deftemplate Actitud   		(declare (from-class Actitud)))
(deftemplate Explicacion    (declare (from-class Explicacion)))

(defrule reluctancia-a-pasar-tiempo-con-romeo
    "Julieta no desea salir en citas con Romeo como lo hacian usualmente"
    ?a <- (Actitud {id == 9000})
    =>
    (add (new Explicacion 001 "Julieta desea tener un poco de espacio para ella" 0.90)))
	
(defrule fastidiada-critica-argumentativa-con-romeo
    "Julieta actua inusualmente fastidiada con Romeo cuando se reúne con él"
    ?a <- (Actitud {id == 1000})
    =>
    (add (new Explicacion 002 "Julieta busca una justificación para una infidelidad pasada" 0.20)))

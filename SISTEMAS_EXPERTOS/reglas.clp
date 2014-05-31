
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
    (add (new Explicacion 002 "Julieta busca una justificacion para una infidelidad pasada" 0.20)))

(defrule olvida-fechas-especiales-en-relacion
    "Julieta empieza a olvidar aniversarios y fechas especiales en la relacion"
    ?a <- (Actitud {id == 8000})
    =>
    (add (new Explicacion 003 "Julieta tiene sobrecarga de actividades personales" 0.90)))

(defrule menor-interes-a-la-relacion
    "Julieta empieza a olvidar aniversarios y fechas especiales en la relacion"
    ?a <- (Actitud {id == 8000})
    =>
    (add (new Explicacion 004 "Julieta presenta menor interes a la relacion" 0.60)))
(defrule menor-interes-a-la-relacion-2
    "Julieta empieza a olvidar aniversarios y fechas especiales en la relacion"
    ?a <- (Actitud {id == 8000})
    =>
    (add (new Explicacion 005 "Julieta presenta menor interes a la relacion" 0.20)))
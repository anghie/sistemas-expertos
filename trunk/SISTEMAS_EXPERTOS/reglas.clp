
(import pe.edu.pucp.sistemasexpertos.proyecto.modelo.*)
(deftemplate Persona        (declare (from-class Persona)))
(deftemplate Actitud   		(declare (from-class Actitud)))
(deftemplate Nodo   		(declare (from-class Nodo)))
(deftemplate Explicacion    (declare (from-class Explicacion)))

(defrule reluctancia-a-pasar-tiempo-con-romeo
    "Julieta no desea salir en citas con Romeo como lo hacian usualmente"
    ?a <- (Nodo {id == 9000})
    =>
    (add (new Explicacion 001 "Julieta desea tener un poco de espacio para ella" 1.00 ?a))
    (add (new Explicacion 004 "Julieta presenta menor interes a la relacion" 0.20 ?a))
    (add (new Explicacion 003 "Julieta tiene sobrecarga de actividades personales" 0.10 ?a))
)
	
(defrule fastidiada-critica-argumentativa-con-romeo
    "Julieta actua inusualmente fastidiada con Romeo cuando se reúne con él"
    ?a <- (Nodo {id == 1000})
    =>
    (add (new Explicacion 004 "Julieta presenta menor interes a la relacion" 0.20 ?a))
    (add (new Explicacion 002 "Julieta busca una justificacion para una infidelidad pasada" 1.00 ?a))
)

(defrule olvida-fechas-especiales-en-relacion
    "Julieta empieza a olvidar aniversarios y fechas especiales en la relacion"
    ?a <- (Nodo {id == 8000})
    =>
    (add (new Explicacion 003 "Julieta tiene sobrecarga de actividades personales" 0.90 ?a))
    (add (new Explicacion 004 "Julieta presenta menor grado de interes a la relacion" 0.60 ?a))
)

(defrule desenamoramiento
    "Julieta desea tener un poco de espacio para ella"
    ?e <- (Explicacion {id == 001})
    =>
    (add (new Explicacion 005 "Julieta ha perdido sentimientos de afecta hacia su pareja o desenamoramiento"  0.50 ?e))
)

(defrule mas-desenamoramiento
    "Julieta presenta menor grado de interes a la relacion"
    ?e <- (Explicacion {id == 004})
    =>
    (add (new Explicacion 005 "Julieta ha perdido sentimientos de afecta hacia su pareja o desenamoramiento"  0.50 ?e))
)

(defrule infidelidad
    "Julieta busca una justificacion para una infidelidad pasada"
    ?e <- (Explicacion {id == 002})
    =>
    (add (new Explicacion 006 "Julieta le es o ha sido infiel a Romeo en el pasado"  1.0 ?e))
)

(defrule algo-le-incomodo
    "Julieta actua inusualmente fastidiada con Romeo cuando se reúne con él"
    ?e <- (Nodo {id == 1000})
    =>
    (add (new Explicacion 007 "Julieta se ha disgustado por un acto o comentario de Romeo sin aún confesárselo verbalmente"  1.0 ?e))
)


(defrule es-solo-por-unos-dias
    "Julieta actua inusualmente fastidiada con Romeo cuando se reúne con él"
    ?e <- (Nodo {id == 1000})
    =>
    (add (new Explicacion 008 "Julieta presenta cambios de humor propios de cambios hormonales periódicos"  1.0 ?e))
)

(defrule particularidades-de-genero
    "Julieta presenta cambios de humor propios de cambios hormonales periódicos"
    ?e <- (Explicacion {id == 008})
    =>
    (add (new Explicacion 009 "Estas actitudes se originan por las particularidades de género"  1.0 ?e))
)

(defrule baja-comunicacion
    "Julieta se ha disgustado por un acto o comentario de Romeo sin aún confesárselo verbalmente"
    ?e <- (Explicacion {id == 007})
    =>
    (add (new Explicacion 010 "Julieta y Romeo tienen un bajo grado de comunicación entre ellos"  1.0 ?e))
)
package com.androidteam.presentacion.middleware

import com.androidteam.mvi.MiddlewareEffect
import com.androidteam.presentacion.state.LDillonReduceAction
import com.androidteam.presentacion.state.LDillonSideEffect
import com.androidteam.presentacion.state.LDillonViewIntent
import com.androidteam.presentacion.state.LDillonViewState

class LDillonMiddleware (

) : MiddlewareEffect<
        LDillonViewState,
        LDillonViewIntent,
        LDillonReduceAction,
        LDillonSideEffect
    > {
    override suspend fun process(
        intent: LDillonViewIntent,
        currentState: () -> LDillonViewState,
        dispatchEffect: suspend (LDillonSideEffect) -> Unit,
        dispatch: suspend (LDillonReduceAction) -> Unit
    ) {
        when (intent) {
            LDillonViewIntent.clearDataClicked -> {

            }
            is LDillonViewIntent.processInfoClicked -> {
                dispatch(LDillonReduceAction.datosTraidosChanged(intent.datos))
            }
        }
    }
}

var textoPrueba = "La Importancia de la Adaptación al Cambio en la Era Digital\n" +
        "En la última década, la tecnología ha cambiado la forma en que vivimos, trabajamos y nos comunicamos. A medida que el mundo se digitaliza, la capacidad de adaptación se ha convertido en una habilidad esencial tanto para individuos como para organizaciones. La transformación digital está ocurriendo a una velocidad sin precedentes, impulsada por el crecimiento del internet, la computación en la nube, la inteligencia artificial y el internet de las cosas (IoT). Estos avances han cambiado la manera en la que las empresas operan, así como la forma en la que los consumidores interactúan con los productos y servicios.\n" +
        "\n" +
        "Uno de los mayores desafíos que enfrentan las organizaciones en la actualidad es mantenerse al día con estos cambios tecnológicos. No es suficiente con simplemente adoptar la última tecnología; es necesario entender cómo esta tecnología puede integrarse de manera efectiva en los procesos de negocio para mejorar la eficiencia y la productividad. Por ejemplo, el uso de la inteligencia artificial para el análisis de datos permite a las empresas tomar decisiones informadas basadas en grandes volúmenes de información, lo que les da una ventaja competitiva significativa en sus respectivos mercados.\n" +
        "\n" +
        "Al mismo tiempo, la digitalización ha generado una nueva demanda de habilidades. Ya no basta con tener conocimientos básicos en informática; los empleados deben tener competencias en áreas como análisis de datos, ciberseguridad, marketing digital y gestión de proyectos tecnológicos. Las habilidades blandas, como la comunicación efectiva, la colaboración en entornos digitales y la capacidad de aprender de forma autónoma, también han ganado una importancia considerable en el mundo laboral moderno. Las empresas están invirtiendo cada vez más en la formación continua de sus empleados para asegurarse de que están preparados para enfrentar los retos de un entorno digital en constante evolución.\n" +
        "\n" +
        "Sin embargo, la adaptación al cambio no es solo una cuestión de habilidades técnicas. La cultura organizacional también juega un papel crucial. Las empresas que fomentan una cultura de innovación y flexibilidad tienen más probabilidades de prosperar en la era digital. Esto implica crear un ambiente donde se valore la creatividad, se permita el aprendizaje a partir de los errores y se incentive la colaboración entre diferentes departamentos. La gestión del cambio, por lo tanto, no solo depende de la implementación de nuevas herramientas tecnológicas, sino también de cómo se gestiona el cambio cultural dentro de la organización.\n" +
        "\n" +
        "Por otro lado, la transformación digital también ha planteado desafíos éticos y de privacidad. La recopilación y el análisis de datos a gran escala han generado preocupaciones sobre la privacidad de los usuarios y la seguridad de la información. Las empresas deben equilibrar la necesidad de datos para mejorar sus servicios con el respeto a la privacidad de los clientes. Esto ha llevado a la creación de nuevas regulaciones, como el Reglamento General de Protección de Datos (GDPR) en Europa, que buscan proteger los derechos de los ciudadanos en la era digital.\n" +
        "\n" +
        "Además, la digitalización ha cambiado la forma en que las personas se relacionan entre sí. Las redes sociales, los foros en línea y las plataformas de mensajería instantánea han transformado la comunicación, permitiendo que las personas se conecten y compartan información de manera instantánea, sin importar la distancia. Esto ha creado una sociedad más conectada, pero también ha generado nuevos problemas, como la desinformación y el ciberacoso. Las plataformas digitales han tenido que desarrollar algoritmos y políticas para combatir estos problemas, pero aún queda mucho por hacer para asegurar que el entorno digital sea un lugar seguro para todos.\n" +
        "\n" +
        "En el ámbito educativo, la transformación digital ha revolucionado la forma en que se imparte y se recibe la educación. Las plataformas de aprendizaje en línea, como MOOCs (Massive Open Online Courses), han democratizado el acceso al conocimiento, permitiendo a personas de todo el mundo aprender nuevas habilidades a su propio ritmo. La educación a distancia ha ganado popularidad, especialmente durante la pandemia de COVID-19, que obligó a instituciones educativas a adaptarse rápidamente a un modelo de enseñanza en línea. Esto ha puesto de manifiesto la importancia de la infraestructura digital y la capacitación en habilidades tecnológicas tanto para estudiantes como para profesores.\n" +
        "\n" +
        "La globalización es otro fenómeno que se ha visto potenciado por la digitalización. Las barreras geográficas ya no son un obstáculo para el comercio y la colaboración internacional. Las empresas pueden acceder a nuevos mercados en todo el mundo, encontrar proveedores más eficientes y trabajar con talento global. Sin embargo, esto también ha generado competencia internacional, obligando a las empresas a ser más innovadoras y eficientes para mantenerse relevantes en un mercado globalizado.\n" +
        "\n" +
        "Finalmente, es importante destacar que la adaptación al cambio no es algo que se logre de la noche a la mañana. Requiere una mentalidad de aprendizaje continuo y la disposición para enfrentar la incertidumbre con una actitud positiva. Tanto las personas como las organizaciones deben estar dispuestas a cuestionar el statu quo, experimentar con nuevas ideas y estar abiertas a las oportunidades que trae consigo la disrupción tecnológica. En un mundo que cambia tan rápidamente, la resiliencia y la capacidad de adaptación se han convertido en habilidades clave para el éxito.\n" +
        "\n" +
        "En conclusión, la era digital ha traído consigo una serie de desafíos y oportunidades que requieren una adaptación constante. La transformación digital no solo se trata de tecnología, sino también de personas, procesos y cultura. Aquellos que logren adaptarse y evolucionar con estos cambios estarán mejor posicionados para prosperar en el futuro. La clave está en adoptar una mentalidad flexible, centrada en el aprendizaje continuo, y en estar siempre preparados para el próximo gran cambio que, sin duda, está a la vuelta de la esquina.\n" +
        "\n"
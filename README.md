![BOKU NO PEDRO](https://github.com/bangfeal/boku-no-pedro/blob/main/Boku_no_Pedro!.png)

Boku no Pedro es un juego estilo novela visual donde el jugador esta dentro 
de un triangulo amoroso entre Pedro Sanchez y Mariano Rajoy con decisiones
en las escenas y capitulos que pintan una corta historia y llevan finales 
diferentes dependiendo de tus acciones.

## Como funciona?
En esencia es una imagen sobre cual hemos pintado unos paneles* que sacan informacion
de un .json que guarda cada escena con personajes, decisiones, imagenes y los efectos
que llevan las decisiones. @bangfeal escribio las clases de Parser, Scene, Dialog(ue)
y unas otras que se usan en conjunto.

### La estructura del JSON es super simple, y aqui hay un ejemplo:
```json
{
  "background": "bg1.jpg", - FONDO DE LA ESCENA
  "dialog": {
      "text": [
          [
            "Sanchez", - NOMBRE DE PERSONAJES
            "sanchez_standing.png", - SPRITE DE PERSONAJE
            null,
            "Por siete votos... tienes el culo roto!" - DIALOGO
          ],
          [
            "Sanchez", - NOMBRE
            "src/images/sprites/PedroSanchez.png", - SPRITE
            null,
            "Esa nenita ta enterita" - DIALOGO..
          ],
          [
            "Sanchez",
            "sanchez_standing.png",
            null,
            "Y tiene tremendo"
          ],
          [
            "Epstein",
            "src/images/ChoiceBackground.png",
            null,
            "Jeffrey Epstein Didnt Kill Himself"
          ]
      ],
    "choice": [
      {
        "text": "Epstein killed himself", - TEXTO QUE VES EN LA OPCION
        "scene": "epstein_killed.json" - ESCENA A LA CUAL TE LLEVA
      },
      {
        "text": "Epstein did not kill himself",
        "scene": "act1_scene3.json"
      }
    ]
  }
}
```
En esencia [FELIX EXPLICALO AQUI!]



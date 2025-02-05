package com.example.triforceheroes

class GameProvider {
    companion object {
        val gameList = mutableListOf<Game>(
            Game(
                id = "ZELDA1",
                title = "The Legend of Zelda",
                releaseYear = "1986",
                platform = "NES",
                description = "El primer juego de la saga, donde Link debe rescatar a la princesa Zelda del malvado Ganon y recuperar la Trifuerza.",
                userNotes = "",
                imagen = "https://imgs.search.brave.com/kkN3qvrYmS7JOpnLF4F7DbLPR26xCDO55GMLbdOJuag/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly90My5m/dGNkbi5uZXQvanBn/LzA5LzE0Lzc2LzA2/LzM2MF9GXzkxNDc2/MDY5NV96REtwUTU3/d1kwc1dVVTFrN0dR/dmdWeTlpY1FkWEE5/TS5qcGc",
                isFavorite = false
            ),
            Game(
                id = "ZELDA2",
                title = "Zelda II: The Adventure of Link",
                releaseYear = "1987",
                platform = "NES",
                description = "Un juego con un enfoque RPG y vista lateral en el que Link debe despertar a la princesa Zelda de su letargo magico.",
                userNotes = "",
                imagen = "https://imgs.search.brave.com/QrWw2R6Lj8NWPQ9VBdim1Mde2wCnElBcn0HQmWTUYok/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pbWFn/ZS5qZXV4dmlkZW8u/Y29tL2ltYWdlcy1z/bS9ucy96L2UvemVs/Mm5zMGYuanBn",
                isFavorite = false
            ),
            Game(
                id = "ZELDA3",
                title = "The Legend of Zelda: A Link to the Past",
                releaseYear = "1991",
                platform = "SNES",
                description = "Link explora Hyrule y el Reino Oscuro para derrotar a Ganon y rescatar a Zelda en un juego con vista aerea clasica.",
                userNotes = "",
                imagen = "https://imgs.search.brave.com/y3rgRC0lO2p61vp1oSC62HrEa4uXd8eoS2O2Wm78tag/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9ibG9n/LmZhbHZhcmV6LmVz/L3VwbG9hZHMvMjAy/MS8wMy90bG96LWEt/bGluay10by10aGUt/cGFzdC1zbmVzLmpw/Zw",
                isFavorite = false
            ),
            Game(
                id = "ZELDA4",
                title = "The Legend of Zelda: Link’s Awakening",
                releaseYear = "1993",
                platform = "Game Boy",
                description = "Link naufraga en la Isla Koholint y debe despertar al Pez del Viento para escapar.",
                userNotes = "",
                imagen = "https://imgs.search.brave.com/JiM-Lw4Kw7Lw8EzmYVvV5heP465rkVd0Oqf7DbWmTaE/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly93d3cu/bm9zb2xvYml0cy5j/b20vaW1hZ2VuZXMv/anVlZ28vdGhlLWxl/Z2VuZC1vZi16ZWxk/YS1saW5rLXMtYXdh/a2VuaW5nLWR4LWdh/bWUtYm95LWNvbG9y/XzI4MjE4MDc4Njdf/dC5qcGc",
                isFavorite = false
            ),
            Game(
                id = "ZELDA5",
                title = "The Legend of Zelda: Ocarina of Time",
                releaseYear = "1998",
                platform = "Nintendo 64",
                description = "Un clasico revolucionario en 3D donde Link viaja en el tiempo para detener a Ganondorf y salvar Hyrule.",
                userNotes = "",
                imagen = "https://imgs.search.brave.com/_FiSoAickP6DPZlURd466GemcyQJKknfjR3rrNOsJtM/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL00v/TVY1Qk5HVmpNamd4/WldFdFlUVXlOaTAw/TVRFM0xXRmpZV010/TWpNM1pHUXpNRFEz/TkdJM1hrRXlYa0Zx/Y0djQC5qcGc",
                isFavorite = false
            ),
            Game(
                id = "ZELDA6",
                title = "The Legend of Zelda: Majora’s Mask",
                releaseYear = "2000",
                platform = "Nintendo 64",
                description = "Link debe salvar Termina de la luna que caera en tres dias, usando mascaras con habilidades especiales.",
                userNotes = "",
                imagen = "https://imgs.search.brave.com/E5CrvFDfzP2-VNtqswzeSefufdeifoOPYo1hFzo8GPU/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL0kv/ODEtaUd5eXo1LUwu/anBn",
                isFavorite = false
            ),
            Game(
                id = "ZELDA7",
                title = "The Legend of Zelda: Oracle of Ages",
                releaseYear = "2001",
                platform = "Game Boy Color",
                description = "Link viaja en el tiempo para salvar a Nayru y derrotar a Veran.",
                userNotes = "",
                imagen = "https://imgs.search.brave.com/yqrjDhoWFmN_8Mzro47FkAes8ZmEc6gLM8XpCAzxG-Y/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pbWFn/ZS5qZXV4dmlkZW8u/Y29tL2ltYWdlcy1z/bS9nYi96L2UvemVs/YWdiMGYuanBn",
                isFavorite = false
            ),
            Game(
                id = "ZELDA8",
                title = "The Legend of Zelda: Oracle of Seasons",
                releaseYear = "2001",
                platform = "Game Boy Color",
                description = "Link usa la vara de las estaciones para restaurar el equilibrio en Holodrum y vencer a Onox.",
                userNotes = "",
                imagen = "https://imgs.search.brave.com/-XnakvJ9Wrzb6vhzFvlUMibB_rOBGK_2i8MfKAdHx-A/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pbWFn/ZS5qZXV4dmlkZW8u/Y29tL2ltYWdlcy1z/bS9nYi96L2UvemVs/c2diMGYuanBn",
                isFavorite = false
            ),
            Game(
                id = "ZELDA9",
                title = "The Legend of Zelda: The Wind Waker",
                releaseYear = "2002",
                platform = "GameCube",
                description = "Link navega los mares para rescatar a su hermana y enfrentar a Ganondorf.",
                userNotes = "",
                imagen = "https://imgs.search.brave.com/4A8t5lKmBi9e1ntCU12EgkF2Z9Zq1vvHaWwF01B0fBw/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS52YW5kYWwubmV0/L3QyMDAvMS8yMDAz/NDE1MTYxNTU3XzYu/anBn",
                isFavorite = false
            ),
            Game(
                id = "ZELDA10",
                title = "The Legend of Zelda: Twilight Princess",
                releaseYear = "2006",
                platform = "GameCube / Wii",
                description = "Link se transforma en lobo y explora el Reino del Crepusculo para detener a Zant y Ganondorf.",
                userNotes = "",
                imagen = "https://imgs.search.brave.com/sOdtHijvrKskR7S6eYL7U55VigWVKQQQBIITNLooFhk/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS52YW5kYWwubmV0/L3QyMDAvNTcyMi8y/MDA4MTgyMTE2MTlf/MWIuanBn",
                isFavorite = false
            ),
            Game(
                id = "ZELDA11",
                title = "The Legend of Zelda: Skyward Sword",
                releaseYear = "2011",
                platform = "Wii",
                description = "La historia más antigua de la saga, donde Link explora el cielo y la superficie para forjar la Espada Maestra.",
                userNotes = "",
                imagen = "https://imgs.search.brave.com/IplR-Xcfj-SuN41504SAUklJS3sEBuKrf1l_15fNB7I/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL00v/TVY1Qk9HTXhNRFJq/TXpVdE4yRmlZUzAw/Wm1GbExXSm1NMkl0/WTJWaFkyUmlNRGRo/TnpWaVhrRXlYa0Zx/Y0djQC5qcGc",
                isFavorite = false
            ),
            Game(
                id = "ZELDA12",
                title = "The Legend of Zelda: A Link Between Worlds",
                releaseYear = "2013",
                platform = "Nintendo 3DS",
                description = "Link debe salvar Hyrule y Lorule con la habilidad de convertirse en pintura.",
                userNotes = "",
                imagen = "https://imgs.search.brave.com/6UeVeW-R64A2iuUzTVUEwO5Pb-kMcVF5r-Xe7IuBSTI/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9zdGF0/aWMueHRyYWxpZmUu/Y29tL2NvbnZlcnNp/b25zL0UzTUMtMk02/UTIxNjU5LW1lZGl1/bV93NjQwX2g0ODBf/cTc1LUUzTUMyTTZR/MjE2NTktb3JpZ2lu/YWwtcG9ydGFkYTEz/MTkwLTE1MzY1Njc2/NDQud2VicA",
                isFavorite = false
            ),
            Game(
                id = "ZELDA13",
                title = "The Legend of Zelda: Breath of the Wild",
                releaseYear = "2017",
                platform = "Nintendo Switch",
                description = "Un mundo abierto donde Link explora Hyrule, recupera su memoria y enfrenta a Calamity Ganon.",
                userNotes = "",
                imagen = "https://imgs.search.brave.com/rLPIvNVzp8VxJgCxXk_L1oIMHeFOANuM8sQ98KvNYVc/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS52YW5kYWwubmV0/L3QyMDAvNDMwMzAv/dGhlLWxlZ2VuZC1v/Zi16ZWxkYS1icmVh/dGgtb2YtdGhlLXdp/bGQtMjAxNzMyMTMx/NDI5XzEuanBn",
                isFavorite = false
            ),
            Game(
                id = "ZELDA14",
                title = "The Legend of Zelda: Link's Awakening (Remake)",
                releaseYear = "2019",
                platform = "Nintendo Switch",
                description = "Un remake en 3D del clásico de Game Boy con graficos renovados.",
                userNotes = "",
                imagen = "https://imgs.search.brave.com/2Cx_nTPOLUpBSR8NxI2AG2NHq15GqRyCV3S1frbziZA/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pLmJs/b2dzLmVzLzE1YzQ5/Yy85MWJxdG5nbmRm/bC5fYWNfc2wxNTAw/Xy9vcmlnaW5hbC5q/cGVn",
                isFavorite = false
            ),
            Game(
                id = "ZELDA15",
                title = "The Legend of Zelda: Tears of the Kingdom",
                releaseYear = "2023",
                platform = "Nintendo Switch",
                description = "Secuela de *Breath of the Wild*, donde Link explora las islas flotantes de Hyrule y enfrenta nuevas amenazas.",
                userNotes = "",
                imagen = "https://www.mielectro.es/rep/9f5d/2439698040/203/jgo-nintendo-switch-zelda-tears-of-kingdom.jpgu",
                isFavorite = false
            )
        )

        val favoriteGames = mutableListOf<Game>()
    }
}

package com.duma.foodiefun.model

object FakeFoodDataSource {
    val dummyFood = listOf(
        Food(
            1,
            "food_1",
            "Nasi Goreng Telur",
            "Nasi goreng sederhana dengan topping segar dan lezat",
            ingredients = listOf(
                "2 piring nasi putih (sebaiknya nasi dingin)",
                "2 butir telur ayam",
                "3 siung bawang putih, cincang halus",
                "2 siung bawang merah, iris tipis",
                "1 sdm kecap manis",
                "1 sdm saus tiram",
                "½ sdt garam",
                "¼ sdt merica bubuk",
                "½ sdt kaldu bubuk",
                "1 sdm minyak goreng",
                "1 buah tomat, iris tipis",
                "1 buah timun, iris tipis",
                "1 butir telur, buat telur mata sapi",
                "1 batang daun sup, cincang halus"
            ),
            instructions = listOf(
                "Panaskan minyak di wajan, tumis bawang putih dan bawang merah hingga harum.",
                "Masukkan 2 butir telur, orak-arik hingga matang.",
                "Tambahkan nasi putih, aduk rata dengan telur dan bumbu.",
                "Tuangkan kecap manis, saus tiram, garam, merica, dan kaldu bubuk. Aduk hingga bumbu meresap dan nasi berwarna merata.",
                "Angkat dan sajikan nasi goreng di piring.",
                "Tambahkan telur mata sapi di atasnya.",
                "Tata irisan tomat dan timun di sisi piring.",
                "Taburkan daun sup cincang sebagai pelengkap.",
                "Nasi goreng telur siap dinikmati!"
            ),
            false
        ),

        Food(
            2,
            "food_2",
            "Bakso manis pedas",
            "Bakso dengan rasa pedas dan manis cocok dijadikan cemilan maupun lauk",
            ingredients = listOf(
                "300 gram bakso",
                "1 buah bawang bombai, cincang-cincang",
                "4 sdm saus pedas",
                "2 sdm kecap manis",
                "2 sdm saus tiram",
                "5 buah jeruk kunci, ambil airnya",
                "Garam, gula secukupnya",
                "200 ml air",
                "2 sdm margarine",
                "Bumbu halus: 10 buah cabai rawit atau sesuai selera",
                "Bumbu halus: 4 siung bawang putih"

            ),
            instructions = listOf(
                "Panaskan margarine lalu tumis bumbu halus dan bombai sampai harum, masukkan bakso, aduk-aduk",
                "Masukkan saus pedas, saus tiram, kecap manis dan air jeruk kunci, aduk rata lalu tuang air.",
                "Masak sampai air menyusut masukkan gula dan sedikit garam, masak sampai air habis test rasa lalu angkat.",
                "Sajikan.",
            ),
            false
        ),

        Food(
            3,
            "food_3",
            "Jamur Pedas",
            "Jamur krispi yang renyah di luar dan lembut di dalam, dilumuri dengan bumbu pedas khas yang meresap sempurna. Cocok sebagai camilan atau lauk pendamping yang bikin nagih.",
            ingredients = listOf(
                "Jamur tiram",
                "250 gr tepung serba guna",
                "3 sdm tepung meizena",
                "4 siung bawang putih (haluskan)",
                "1 sdt merica bubuk",
                "1 sdt garam",
                "1 sdt kaldu bubuk",
            ),
            instructions = listOf(
                "Cuci bersih jamur (peras sampai airnya hilang).",
                "Masukkan bumbu ke dalam wadah yang berisi jamur (aduk-aduk hingga merata), kemudian marinasi sampai 10 menit.",
                "Masukkan jamur ke dalam tepung kering (mix tepung serba guna dan meizena) balut hingga merata.",
                "Goreng jamur hingga golden brown.",
                "Masukkan tempe, oseng-oseng sebentar. Koreksi rasa.",
                "Sajikan dengan saus tomat atau cabai."
            ),
            false
        ),

        Food(
            4,
            "food_4",
            "Oseng Kacang Panjang Tempe Kecap Pedas",
            "Tumis kacang panjang yang renyah berpadu dengan tempe goreng yang gurih, dimasak dengan bumbu kecap manis dan cabai yang memberikan sensasi pedas manis yang menggugah selera.",
            ingredients = listOf(
                "1 ikat kacang panjang (potong korek api)",
                "1 papan tempe besar (potong dadu)",
                "4 siung bawang merah",
                "3 siung bawang putih",
                "5 cabai rawit merah",
                "10 cabai rawit hijau",
                "Garam secukupnya",
                "Gula pasir secukupnya",
                "Kaldu bubuk secukupnya",
                "Kecap manis secukupnya",
                "Saori saus tiram secukupnya"
            ),
            instructions = listOf(
                "Cuci bersih kacang panjang yang sudah dipotong korek api. Sisihkan.",
                "Goreng tempe yang sudah dipotong hingga keemasan. Tiriskan.",
                "Tumis bumbu halus hingga harum, tambahkan garam, gula, kecap, saori, dan kaldu bubuk.",
                "Masukkan kacang panjang, aduk hingga tercampur rata dan tambahkan sedikit air.",
                "Masukkan tempe, oseng-oseng sebentar. Koreksi rasa.",
                "Angkat dan sajikan."
            ),
            false
        ),

        Food(
            5,
            "food_5",
            "Orak Arik Telur",
            "Telur yang diorak-arik dengan bumbu sederhana, menghasilkan tekstur lembut dan cita rasa gurih. Cocok disajikan sebagai lauk pendamping yang praktis dan lezat.",
            ingredients = listOf(
                "Telur",
                "Wortel (potong dadu)",
                "Bakso (potong sesuai selera)",
                "Garam secukupnya, saori saus tiram, gula pasir, merica bubuk dan kaldu bubuk",
                "1/2 bawang bombai potong besar",
                "3 siung bawang putih",
                "6 cabai rawit merah"
            ),
            instructions = listOf(
                "Goreng bakso sisihkan.",
                "Goreng telur kemudian orak arik.",
                "Tumis bumbu yang sudah diiris sampai harum dan layu.",
                "Masukkan semua bahan aduk-aduk sampai rata dan jangan lupa tambahkan sedikit air.",
                "Masukkan garam, gula, merica bubuk, saori dan kaldu bubuk. Aduk sampai merata. Koreaksi rasa.",
                "Angkat dan sajikan."
            ),
            false
        ),

        Food(
            6,
            "food_6",
            "Capcai Goreng",
            "Tumis aneka sayuran segar seperti wortel, kembang kol, dan sawi dengan tambahan bumbu gurih khas oriental. Kaya rasa dan penuh nutrisi dalam setiap suapan.",
            ingredients = listOf(
                "1 ikat sawi ijo",
                "1 buah sawi putih",
                "2 buah wortel",
                "1 buah kembang kol",
                "2 siung bawang putih",
                "3 butir bawang merah",
                "1/2 bawang bombai",
                "1 sdm saus tiram",
                "1 sdt saus Inggris",
                "1 sdt kecap asin",
                "1 sdm maizena, campur dengan sedikit air",
                "1 sdt minyak wijen",
                "Air secukupnya",
                "Garam",
                "Lada",
            ),
            instructions = listOf(
                "Tumis bawang merah dan bawang putih hingga harum, masukkan bawang bombai.",
                "Masukkan wortel, aduk-aduk sampai setengah matang.",
                "Beri air secukupnya, masukkan saus tiram, kecap Inggris, kecap asin, garam, lada. Aduk-aduk hingga kuah mendidih masukkan maizena, aduk-aduk.",
                "Masukkan sawi, kembang kol, aduk-aduk",
                "Test rasa, terakhir masukkan minyak wijen. Angkat.",
                "Sajikan."
            ),
            false
        ),

        Food(
            7,
            "food_7",
            "Sambal Terong",
            "Irisan terong yang digoreng hingga empuk, kemudian disiram dengan sambal pedas gurih yang menggugah selera. Paduan rasa pedas dan manisnya membuat lauk ini semakin nikmat. Dikolaborasi dengna jamur Shimeji (optional)",
            ingredients = listOf(
                "10 buah terong bulat, cuci bersih, belah jadi 4",
                "1 bungkus jamur shimeji putih, potong akarnya",
                "3 sdm teri nasi, goreng kering",
                "3 siung bawang putih",
                "6 siung bawang merah",
                "1 buah tomat besar",
                "3 buah cabai merah besar",
                "15 buah cabai rawit (sesuai selera)",
                "1,5 sdt terasi goreng",
                "1 sdt gula merah sisir",
                "Gula, garam, merica, dan kaldu bubuk secukupnya"
            ),
            instructions = listOf(
                "Tumis bumbu halus hingga benar-benar matang, masukkan terong beri sedikit air, tunggu hingga terong mulai empuk.",
                "Masukkan jamur shimeji, aduk-aduk hingga rata.",
                "Koreksi rasa, tunggu hingga air menyusut, terakhir taburi dengan teri nasi.",
            ),
            false
        ),

        Food(
            8,
            "food_8",
            "Udang Goreng Asem Gurih",
            "Udang segar yang digoreng hingga renyah, dipadukan dengan bumbu asam gurih yang meresap sempurna. Perpaduan rasa yang segar dan lezat dalam setiap gigitan.",
            ingredients = listOf(
                "500 gram udang",
                "1 sdm Fiber Creme",
                "1 sdm asam jawa, remas-remas",
                "3 siung bawang putih (parut)",
                "Cabai rawit",
                "Saus tiram",
                "Kecap manis",
                "Garam",
                "Lada",
                "Gula",
            ),
            instructions = listOf(
                "Cuci bersih udang belah punggung dan buang kotoran dan kulit sisakan ekor.",
                "Dalam bowl campur air asam jawa, bawang putih, sedikit garam dan lada, lalu masukkan udang aduk rata marinasi kurang lebih 30 menit.",
                "Panaskan dua sendok makan minyak goreng lalu tuang udang yang sudah dimarinasi tadi masak sampai mendidih lalu tambahkan Fiber Creme, bumbui saus tiram, kecap manis dan sedikit gula.",
                "Masak sampai saus mengental masukkan cabai rawit (bila suka pedas) tes rasa, angkat dan sajikan.",
            ),
            false
        ),

        Food(
            9,
            "food_9",
            "Oseng Sawi Putih Jagung Manis",
            "Tumis sawi putih yang lembut dengan jagung manis yang renyah, menghasilkan kombinasi rasa gurih dan manis yang pas. Sajian sederhana namun penuh cita rasa.",
            ingredients = listOf(
                "1 buah/bonggol sawi putih potong-potong",
                "1 buah jagung manis, serut",
                "3 siung bawang putih cincang",
                "Secukupnya cabai",
                "Gula garam kaldu bubuk secukupnya",
                "Air secukupnya",
            ),
            instructions = listOf(
                "Tumis bawang putih sampai harum, masukkan cabai uleg, jagung, dan air.",
                "Tunggu sampai jagung empuk/cukup matang.",
                "Masukkan sawi putih, tambah garam gula dan kaldu bubuk.",
                "Aduk rata tunggu sawi layu, matikan kompor",
                "Sajikan pada mangkuk",
            ),
            false
        ),

        Food(
            10,
            "food_10",
            "Telur Geprek",
            "Telur goreng yang digeprek dan disiram dengan sambal pedas nikmat. Perpaduan renyahnya telur dan pedasnya sambal menciptakan sensasi makan yang menggugah selera.",
            ingredients = listOf(
                "1 butir telur dan garam secukupnya",
                "Adonan basah: 2 sdm tepung bumbu sajiku",
                "Adonan basah: Air secukupnya",
                "Adonan kering: 7 sdm tepung bumbu sajiku",
                "Adonan kering: 2-3 sdm tepung maizena",
                "Adonan kering: 15 cabai rawit merah",
                "Adonan kering: 5 cabai rawit hijau",
                "Adonan kering: 3 butir bawang merah",
                "Adonan kering: 1 siung bawang putih",
                "Adonan kering: Garam secukupnya",
                "Adonan kering: Minyak goreng panas",

            ),
            instructions = listOf(
                "Dadar telur seperti biasa, potong sesuai selera, sisihkan.",
                "Siapkan adonan kering dan adonan basah. (Adonan basah kekentalan sedang).",
                "Masukkan telur ke adonan basah, lalu ke adonan kering. Goreng hingga kecokelatan.",
                "Sambal bawang: Uleg kasar semua bumbu sambal bawang beri sedikit garam lalu siram dengan minyak panas",
                "Penyajian: Geprek/penyet telur diatas cobek, siap disajikan.",
            ),
            false
        ),

        Food(
            11,
            "food_11",
            "Cah Kangkung Terasi Pedas",
            "Tumis kangkung segar dengan bumbu terasi khas yang harum dan pedas menggigit. Menu sederhana yang selalu menggoda selera makan.",
            ingredients = listOf(
                "1 ikat kangkung, petik, bersihkan",
                "1 saset terasi",
                "1 buah tomat, potong dadu",
                "5 butir telur puyuh rebus",
                "5 siung bawang merah",
                "2 siung bawang putih",
                "13 cabai rawit merah",
                "15 cabai rawit hijau",
                "3 buah cabai merah iris serong",
                "1 sdm saori saus tiram",
                "Secukupnya Air, garam, gula, kaldu bubuk, merica bubuk"
                ),
            instructions = listOf(
                "Goreng semua bumbu yang akan dihaluskan dan trasi sampai sedikit layu. Angkat tiriskan.",
                "Haluskan bumbu dan trasi yang sudah digoreng.",
                "Tumis bumbu sampai harum dan matang. Tambahkan Saori.",
                "Masukkan sedikit air. Tunggu sampai mendidih, masukkan kangkung yang sudah dibersihkan tadi. Aduk-aduk sampai merata.",
                "Masukkan garam, gula kaldu bubuk, dan merica bubuk. Koreksi rasa.",
                "Masukkan telur puyuh, tomat, dan cabai iris. Aduk kembali",
                "Angkat dan sajikan."
            ),
            false
        ),

        Food(
            12,
            "food_12",
            "Sayur Asem",
            "Sayur asem segar dengan campuran sayuran dan bumbu yang kaya rasa",
            ingredients = listOf(
                "2,5 liter air putih",
                "1 ikat kacang panjang",
                "1 buah labu siam",
                "1 buah wortel",
                "2 buah jagung manis",
                "Secukupnya kubis",
                "Segenggam daun belinjo",
                "15 buah belimbing wuluh",
                "4 lembar daun salam",
                "Lengkuas geprek",
                "Segenggam kacang tanah/kacang merah",
                "Gula pasir, gula jawa, garam secukupnya",
                "Ulek/Belender:  7 buah cabai merah besar (buang bijinya)",
                "Ulek/Belender:  15 buah cabai rawit (sesuaikan selera pedesnya) 1 saset terasi",
                "Ulek/Belender:  7 siung bawang putih",
                "Ulek/Belender:  9 butir bawang merah",
                "Ulek/Belender:  6 mata asam jawa (buang bijinya)",
            ),
            instructions = listOf(
                "Rebus air bersama lengkuas dan daun salam, masukkan bumbu, tunggu mendidih dan bumbu agak matang.",
                "Masukkan sayur berurutan sesuai tingkat kematangan, misal jagung, kacang, labu siam, kacang panjang, wortel, kubis + daun belinjo, belimbing wuluh.",
                "Jangan lupa koreksi rasa, sesuaikan selera.",
                "Sajikan."
            ),
            false
        ),

        Food(
            13,
            "food_13",
            "Ayam Suir Gurih Pedas",
            "Ayam suwir gurih pedas dengan jagung dan bumbu yang kaya rasa",
            ingredients = listOf(
                "450 gram fillet dada ayam",
                "1 bonggol jagung (sisir)",
                "3 sendok makan Fiber Creme",
                "4 helai daun seledri (iris-iris)",
                "Cabai rawit secukupnya",
                "2 sendok air asam jawa",
                "Saus tiram, kecap manis, kecap asin, garam, lada dan gula secukupnya",
                "150ml air hangat",
                "1 batang serai (memarkan)",
                "2 cm lengkuas (geprek)",
                "Bumbu halus: 8 butir bawang merah",
                "Bumbu halus: 3 siung bawang putih",
                "Bumbu halus: 2 buah kemiri (sangrai)",
                "Bumbu halus: 3 cabai keriting",

            ),
            instructions = listOf(
                "Cuci bersih fillet ayam lalu lumuri jeruk kunci.",
                "Goreng ayam sampai matang lalu suwir-suwir.",
                "Tumis bumbu halus, lengkuas dan serai dengan 2 sendok makan minyak goreng sampai wangi bau langu hilang lalu masukkan ayam suwir.",
                "Campur Fiber Creme dengan air hangat lalu tuang ke dalam tumisan ayam aduk merata.",
                "Setelah mendidih masukkan jagung, bumbui saus tiram, kecap manis, kecap asin, garam, lada, dan gula secukupnya.",
                "Setelah air menyusut masukkan air asam, cabai rawit, dan daun seledri.",
                "Masak sampai air habis, tes rasa, angkat kemudian sajikan."
            ),
            false
        ),
        Food(
            14,
            "food_14",
            "Roti John, Roti Tawar",
            "Roti tawar isi lezat dengan chicken luncheon, telur, dan keju",
            ingredients = listOf(
                "Roti tawar",
                "Chicken luncheon (bisa ganti kornet, sosis, daging-dagingan)",
                "Telur kocok lepas (kasih garam merica)",
                "Bawang bombai, cincang",
                "Daun bawang, iris",
                "Keju jika suka",
                "Margarin",
                "Saus tomat"
            ),
            instructions = listOf(
                "Lelehkan margarin, tumis luncheon + bombai sampai wangi, tuang telur, taburi daun bawang + keju, tutup dengan selembar roti tawar, masak sampai matang. Beri saus tomat.",
                "Oles bagian atas roti tawar dengan margarin, balik, panggang sampai garing kecoklatan. Lipat dua, sajikan."
            ),
            false
        ),

        Food(
            15,
            "food_15",
            "Takoyaki Mie",
            "Mie dengan bahan takoyaki yang lezat, sangat nikmat untuk camilan",
            ingredients = listOf(
                "1/2 bungkus mi",
                "3 butir telur, kocok lepas",
                "2 sdm tepung terigu",
                "4 sdm susu cair",
                "1/2 bagian wortel, rebus sebentar, iris halus",
                "1 buah smocked beef, iris halus",
                "1 batang daun bawang, iris halus",
                "Garam, Lada, sedikit kaldu bubuk"
            ),
            instructions = listOf(
                "Rebus matang mi, tiriskan dan sisihkan.",
                "Larutkan tepung terigu dengan susu cair, aduk sampai tidak bergerindil.",
                "Masukkan telur, smocked beef, daun bawang, garam, lada, kaldu, telur, dan mie, aduk rata.",
                "Tuang kedalam cetakan takoyaki, masak sampai matang dengan api kecil dan pan ditutup."
            ),
            false
        ),

        Food(
            16,
            "food_16",
            "Mie Gulung Sosis",
            "Mi instan digulung dengan sosis, cocok untuk camilan",
            ingredients = listOf(
                "2 bungkus mi instan",
                "5 buah sosis",
                "Minyak sayur secukupnya",
                "Air untuk merebus"
            ),
            instructions = listOf(
                "Didihkan air, rebus mi hingga matang, angkat.",
                "Campur mi dengan bumbunya, aduk rata, sisihkan.",
                "Potong sosis menjadi 2 bagian dan kerat ujungnya.",
                "Ambil secukupnya mi kemudian gulungkan ke sosis, lakukan sampai habis.",
                "Panaskan minyak, kemudian goreng hingga matang dan angkat.",
                "Sajikan dengan saos sambal atau tomat."
            ),
            false
        ),

        Food(
            17,
            "food_17",
            "Mie Kuah",
            "Mi telur dengan udang, sawi pokcoy, dan kecap manis",
            ingredients = listOf(
                "1 bungkus mi telur",
                "100 gr sawi pokcoy, potong kecil-kecil",
                "50 gr udang kupas",
                "1 butir telur",
                "3 siung bawang putih cincang",
                "Setengah sdt kaldu bubuk rasa ayam"
            ),
            instructions = listOf(
                "Dalam wadah, campur semua bahan kecap. Aduk rata.",
                "Rebus mi telur, bilas dengan air mengalir sambil diangkat agar tidak nempel, lalu tiriskan.",
                "Campur mi telur yang sudah direbus dengan bahan kecap, aduk sampai merata. Sisihkan.",
                "Tumis bawang putih hingga harum, pecahkan telur lalu orak-arik. Masukkan udang tumis sebentar, masukkan sawi pokcoy tumis lagi. Beri kaldu bubuk rasa ayam dan aduk rata.",
                "Masukkan mi yang sudah diaduk dengan bahan kecap tadi. Tumis mi hingga tercampur rata dengan api sedang.",
                "Tes rasa dan sajikan."
            ),
            false
        ),

        Food(
            18,
            "food_18",
            "Sosis Teriyaki",
            "Potongan sosis yang dimasak dengan saus teriyaki manis gurih khas Jepang, menghasilkan hidangan lezat dengan cita rasa yang meresap sempurna",
            ingredients = listOf(
                "10 buah sosis sapi",
                "1 bombai",
                "3 cabai merah besar",
                "3 cabai hijau besar",
                "2 siung bawang putih ukuran besar",
                "3 sdm saos teriyaki",
                "1 sdm saos tiram",
                "1 sdm kecap Inggris",
                "1/2 sdm saos sambal",
                "2 sdm kecap manis (takaran sesuai selera)",
                "1 sdt lada bubuk",
                "1 sdm margarin",
                "Garam secukupnya"
            ),
            instructions = listOf(
                "Buang plastik pembungkus sosis, cuci bersih, satu sosis potong tiga, kerat ujungnya jangan sampai putus.",
                "Panaskan margarin, tumis bawang putih cincang sampai harum, masukkan potongan sosis, aduk-aduk sampai rata lalu masukkan sekitar segelas kecil air matang, bumbui saus, lada bubuk, kecap manis dan garam.",
                "Setelah air mulai susut, masukkan potongan cabai dan bombai, masak lagi sampai cabai dan bombai layu, koreksi rasa."
            ),
            false
        ),

        Food(
            19,
            "food_19",
            "Mie Instan Seblak Macaroni",
            "Perpaduan mie instan dengan seblak khas Bandung yang pedas dan beraroma kuat, ditambah macaroni yang kenyal, menciptakan sensasi makan yang nikmat dan menggugah selera.",
            ingredients = listOf(
                "1 bungkus mi instan rebus, tiriskan",
                "30 gr macaroni rebus tiriskan",
                "Sedikit kerupuk bawang mentah, rendam air panas hingga empuk beri sedikit minyak agar tidak lengket",
                "Secukupnya daun bawang iris",
                "1 buah sosis iris",
                "1 buah telur kocok lepas",
                "2 gelas air",
                "Sedikit garam, gula dan bumbu mi instan",
                "Bumbu halus: Sedikit garam, gula dan bumbu mi instan",
                "Bumbu halus: 2 bawang putih",
                "Bumbu halus: 5 cabai merah keriting",
                "Bumbu halus: 3 rawit atau sesuai selera",
                "Bumbu halus: 1 cm kencur",


            ),
            instructions = listOf(
                "Tumis bumbu halus dengan sedikit minyak, masukkan air, setelah mendidih masukkan kocokan telur diaduk, masukkan macaroni, lalu sosis kerupuk dan mie, beri gula garam bumbu mi instan.",
                "Aduk rata test rasa angkat sajikan taburi dengan daun bawang.",
            ),
            false
        ),
        Food(
            20,
            "food_20",
            "Cah Tauge dan Tahu",
            "Tumisan sederhana yang menggabungkan renyahnya tauge dengan lembutnya tahu, dimasak dengan bumbu gurih dan sedikit kecap untuk cita rasa yang lezat dan sehat.",
            ingredients = listOf(
                "1/4 Tauge (cuci bersih)",
                "3 buah tahu putih (potong dadu)",
                "3 buah tahu putih (potong dadu)",
                "Bumbu iris: 5 buah cabai rawit merah",
                "Bumbu iris: 2 buah cabai merah kriting",
                "Bumbu iris: 3 buah bawang merah",
                "Bumbu iris: 2 siung bawang putih",
                "Bumbu iris: Garam secukupnya",
                "Bumbu iris: Gula pasir secukupnya",
                "Bumbu iris: Kaldu bubuk secukupnya",
                "Bumbu iris: 1 sdm Saori"

            ),
            instructions = listOf(
                "Goreng tahu dan bakso (jangan terlalu kering). Tiriskan.",
                "Tumis bumbu yang sudah di rajang sampai harum.",
                "Tambahkan saori, garam, gula dan kaldu bubuk.",
                "Masukkan tauge tahu dan bakso, aduk sebentar sampai rata. Koreksi rasa (jangan ditambah air).",
                "Angkat dan sajikan.",
            ),
            false
        ),

        Food(
            21,
            "food_21",
            "Mie Goreng",
            "Mie goreng dengan udang dan sayur pokcoy yang lezat",
            ingredients = listOf(
                "1 bungkus mi telur",
                "100 gr sawi pokcoy, potong kecil-kecil",
                "50 gr udang kupas",
                "1 butir telur",
                "3 siung bawang putih cincang",
                "Setengah sdt kaldu bubuk rasa ayam",
                "Bahan Kecap: 1 sdm kecap manis",
                "Bahan Kecap: 2 sdm kecap asin",
                "Bahan Kecap: Seper empat sdt lada bubuk",
                "Bahan Kecap: Setengah sdm saus tiram",
                "Bahan Kecap: 1 sdm minyak sayur",
                "Bahan Kecap: 1 sdt kaldu jamur bubuk"
            ),
            instructions = listOf(
                "Dalam wadah, campur semua bahan kecap. Aduk rata.",
                "Rebus mi telur, bilas dengan air mengalir sambil diangkat agar tidak nempel, lalu tiriskan.",
                "Campur mi telur yang sudah direbus dengan bahan kecap, aduk sampai merata. Sisihkan.",
                "Tumis bawang putih hingga harum, pecahkan telur lalu orak arik.",
                "Masukkan udang tumis sebentar, masukkan sawi pokcoy tumis lagi.",
                "Beri kaldu bubuk rasa ayam, aduk rata.",
                "Masukkan mi yang sudah diaduk dengan bahan kecap tadi. Tumis mi hingga tercampur rata dengan api sedang.",
                "Tes rasa dan sajikan."
            ),
            false
        ),
    )
}
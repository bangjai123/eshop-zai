# TUTORIAL 1
<details>
<summary>REFLEKSI 1</summary>
   
Pada exercise pertama ini, saya telah membuat dua fungsionalitas tambahan pada aplikasi ini. Dalam membuat dua fungsionalitas tersebut, saya berusaha sebaik yang saya bisa untuk melakukan coding sesuai standardnya/ Dari sisi clean code, beberapa hal yang telah saya coba untuk implementasikan agar kode saya mudah terbaca dan "clean" adalah sebagai berikut.
   
- memberikan penamaan yang meaningful. Pada saat memberikan nama untuk variable maupun fungsi, saya berusaha untuk memberikan nama yang mudah dimengerti bahkan oleh orang yang baru sekali melihatnya. Sebagai contoh, saya memberi nama fungsi untuk mencari produk berdasarkan id dengan nama "findProductById". Contoh lain, saya membuat penghitung untuk menghitung berapa jenis item yang telah disimpan dalam aplikasi dengan nama "product Counter".
  
- Penggunaan fungsi yang singkat. Sebagaimana telah dijabarkan pada saat perkuliahan, sebaiknya fungsi yang dibuat oleh programmer dibuat sesingkat mungkin. Fungsi tersebut sebaiknya hanya melakukan satu hal. Selain itu, fungsi yang saya buat memiliki tidak lebih dari 20 baris. Saya juga memecah fungsi yang dapat dipecah. Sebagai contoh, saya memecah fungsi mencari produk dari mengedit dan menghapus. Dengan demikian, masing-masing fungsi hanya memiliki satu fungsionalitas. Sedangkan untuk kebutuhan mencari produknya, saya melakukan pemanggilan fungsi findProductById pada saat ingin mengedit dan menghapus
  
- Menurut penuturan Pak Ade (dosen kelas A), comment bukanlah sesuatu yang sebaiknya dijadikan fokus pada zaman sekarang. Lebih baik menjadikan kode kita terbaca dari pada membuat banyak comment untuk menjelaskan kodenya. Dengan demikian, saya memilih untuk sejelas mungkin menulis penamaan serta penulisan kode sehingga itu terbaca dari pada membuat komen
- 
- Layout dan formatting. Saya menggunakan formatting yang saat ini banyak digunakan yaitu indentasi 4 baris untuk setiap satu indentasi yang diperlukan.

Lalu, dari segi secure coding, terus terang sejauh ini belum terlalu terasa karena code yang dibuat masih berupa aplikasi sederhana yang belum memerlukan keamanan tingkat tinggi. Hal ini dikarenakan aplikasi yang dibuat masih belum membutuhkan hal-hal seperti autentikasi, autorisasi, input data validation, maupun output data encoding. Ke depannya, saya sangat tertarik untuk melatih kemampuan saya dalam melakukan secure coding
</details>
<details>
<summary>REFLEKSI 2</summary>
   
1. Setelah membuat unit test, saya merasa cukup senang karena mungkin itu adalah unit test pertama yang saya buat sendiri. Meskipun masih sangat sederhana, semoga itu menjadi awal yang baik untuk perjalanan saya ke depannya. Jumlah unit test yang dibutuhkan oleh sebuah class sebenarnya mungkin tidak dapat ditentukan secara umum. Tiap class mungkin memiliki jumlah fungsi yang berbeda, kemungkinan atas kasus penyimpangan yang berbeda, serta faktor-faktor lain yang dapat mempengaruhi kebutuhan unit test yang berbeda. Dengan demikian, menurut saya setiap class memiliki kebutuhan yang berbeda. Selain itu, saya melihat bahwa semakin banyak unit test semakin baik karena artinya banyak hal yang terprediksi salah dapat teratasi. Meskipun demikian, kita hanya dapat membuat unit test sebanyak mungkin dari hal-hal yang kita prediksi dapat terjadi. Hal ini berarti sebuah code yang memiliki 100% code coverage belum tentu aman dari bug. Hal ini disebabkan unit test yang kita buat baru dari hal-hal yang kita bisa prediksi
   
2. Apa bila ditinjau dari sisi issue clean code, terdapat beberapa hal yang perlu diperhatikan dan berisiko menurunkan tingkat kualitas clean codenya. Beberapa hal tersebut di antaranya adalah sebagai berikut.
   
   - Kemungkinan terdapat kode yang terduplikasi. Seperti yang disebutkan, keduanya memiliki setup prosedur dan instance variables yang mirip. Hal ini dapat diimprove misalnya dengan membuat superclass yang memiliki kode yang mirip antara keduanya. 
   - Kejelasan tesnya mungkin menjadi sedikit rancu untuk orang lain yang baru melihatnya. Hal ini karena kemiripan keduanya mungkin saja membuat orang menjadi bingung akan perbedaan fungsinya satu sama lain
   
  Dengan demikian, penambahan test sebenarnya adalah sesuatu yang sangat baik. Akan tetapi, kita tetap perlu berusaha untuk memastikan kejelasan kodenya. Hal tersebut dapat dilakukan dengan prinsip-prinsip clean code. Selain itu, kita perlu memastikan bahwa kode yang kita buat tidak redundant. Jika dapat membuatnya diketik hanya satu kali, tidak perlu membuatnya diketik dua kali.
</details>

# TUTORIAL 2
<details>
<summary>REFLEKSI</summary>
   
1. Berdasarkan code scanning yang dilakukan menggunakan SonarCloud, terdapat 3 isu utama pada code saya. Saya memutuskan untuk membetulkan semuanya. Isu tersebut adalah sebagai berikut.
   - Adanya penamaan yang tidak sesuai konvensi
     Terdapat penamaan fungsi yang tidak sesuai konvensi, yaitu fuction "HalamanUtama". Agar sesuai konvensi, saya mengubahnya menjadi camelCase, yaitu "halamanUtama"
   - Adanya bagian kode yang tidak digunakan
     SonarCloud menyarankan untuk menghapus beberapa private attribute yang ada pada class Product karena dianggap tidak berguna. Hal ini dikarenakan tidak ada function yang secara langsung mengubah atau menggunakan attribute-attribute tersebut. Untuk mengatasinya, saya sudah memberi decorative @Getter dan @Setter sehingga semua attribute tersebut sebenanya dapat dijangkau dari luar class.
   - Multi-threading
     SonarCloud menyarankan untuk menghapus salah satu function yang memuat static attribute. SonacCloud menyarankannya karena dikhawatirkan hal tersebut dapat membuat saya secara tidak sengaja menggati nilainya. Padahal attribute tesebut saya gunakan untuk memberikan ID produk, yaitu dengan menghitung banyaknya produk. Solusi yang saya lakukan adalah dengan mengganti ID menggunakan UUID yang digenerate secara random.

2. Sudah. CI/CD adalah kependekan dari Continuous Integration dan Continuous Deployment. Prinsip CI/CD adalah prinsip automasi dalam pembuatan program secara continuous. Yang dilakukan pada tutorial ini adalah mengautomasi testing yang dilakukan dengan menggunakan tool SonarCloud dan ScoreCard. Kedua tools tersebut akan melakukan testing secara otomatis ketika pengguna melakukan perubahan pada repositori atau branch. Untuk deployment, saya menggunakan Koyeb yang akan melakukan deployment ke `https://mild-lizard-bangjai123.koyeb.app/` secara otomatis setiap saya melakukan push ke github. Hal ini sesuai dengan prinsip automasi yang berkelanjutan pada CI/CD.
</details>

# TUTORIAL 3
<details>
<summary>REFLEKSI</summary>
   
1. Prinsip SOLID yang saya implementasikan pada projek saya:
   - S:
     S dalam SOLID berarti _single responsibility principle_. artinya, setiap module pada project sebaiknya hanya memiliki satu role atau job. Hal ini saya lakukan dengan memisahkan Car Controller dan Home Controller dan Project Controller.
   - O:
     O dalam SOLID berarti _open-closed principle_. artinya, kode yang dibuat dapat diextend tanpa mengubah kode yang sudah ada. Saya melakukannya dengan melakukan inheritence dengan membuat atribute dan method pada parent class tidak sensitive pada class tertentu. Dengan demikian, kode dapat diextend tanpa mengubah kode awal
   - L:
     L dalam SOLID berarti _liskov substitution principle_. LSP adalah prinsip di mana jika B adalah subclass dari A, kita dapat melakukan substitusi antara A dan B tanpa menimbulkan _unexpected behavior_ pada kode. Hal ini dapat dilihat pada inheritence yang saya lakukan pada GeneralController (abstract) yang memiliki subclass CarRepository dan ProductRepository.
   - D:
     D dalam SOLID berarti _Dependency inversion principle_. Prinsip ini menyarankan penggunaan interface dari pada class untuk memanggil objek pada class lain. Saya mengimplementasikannya dnegna membuat interface GeneralService<T> untuk menampung class CarServiceImpl dan ProductServiceImpl

2. Beberapa keuntungan SOLID:
   Secara umum, prinsip SOLID bertujuan untuk meningkatkan maintainability dari kode yang kita miliki. prinsip SOLID akan menghasilkan kode yang lebih clean, lebih modular, dan lebih mudah dimaintain. Dengan begitu, SOLID akan mengurangi risiko software yang fragile, mengurangi effort dalam pengembangan aplikasi, dan mendorong pengembangan sistem software yang lebih robust dan adaptable.

   Contoh penggunaan prinsip SOLID pada projek saya adalah sebagaimana telah saya sebutkan pada poin-poin di nomor satu. Saya melihat, penerapan SRP pada project saya memungkinkan saya melakukan _tracking_ terhadap error secara lebih _effortless_ karena saya mengetahui bagian mana terjadinya error. Selain itu, penerapan OCP dan LSP memberikan saya fleksibilitas yang lebih tinggi dalam melakukan perubahan terhadap kode saya.

4. Beberapa kerugian tidak menerapkan SOLID:
   Tidak dilakukannya prinsip-prinsip SOLID dapat mengurangi maintainability program yang dibuat. Modifikasi yang akan dilakukan di masa depan bisa jadi membutuhkan effort yang lebih besar dari pada jika menerapkan prinsip SOLID. Selain itu, tidak diterapkannya SOLID membuat kode menjadi kurang reusable, memiliki ketergantungan yang tinggi, dan kemungkinan suatu perubahan menyebabkan perubahan behaviour tidak terduga pada bagian lain.

   Dalam konteks projek saya, saya memperkirakan, jika saya tidak menerapkan SRP, saya akan kesulitan untuk memaintain bagian fungsionalitas tertentu pada kode saya. Hal ini dapat terjadi jika tidak menggunakan SRP karena kode yang saya buat akan memiliki fungsi terlalu banyak pada satu bagian. Hal ini akan sangat melelahkan untuk untuk memaintainnya. Selain itu, tanpa OCP dan LSP, saya akan memiliki fleksibilitas yang rendah dalam mengubah kode saya. Hal ini disebabkan kode yang saya miliki bisa saja memiliki ketergantungan satu sama lain. Dengan demikian, mengubah sebagian kode dapat berisiko mengubah banyak behaviour dari kode secara umum.

</details>

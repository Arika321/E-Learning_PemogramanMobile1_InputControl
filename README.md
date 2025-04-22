# Penjelasan Projek E-Learning Input Control

##  Time Picker & Date Picker
Fungsi untuk memilih tanggal menggunakan `DatePickerDialog` telah dimplementasikan dalam method `showDatePicker()`. Berikut penjelasannya:

### Kode yang digunakan:
```kotlin
private fun showDatePicker() {
    val calendar = Calendar.getInstance()
    val datePickerDialog = DatePickerDialog(
        this,
        { _, year, month, dayOfMonth ->
            val selectedDate = "$dayOfMonth/${month + 1}/$year"
            // Lakukan sesuatu dengan selectedDate
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )
    datePickerDialog.show()
}

penjelasan
DatePickerDialog: Sebuah dialog yang memungkinkan pengguna untuk memilih tanggal.

Parameter pertama adalah konteks (this), yang merujuk ke aktivitas saat ini.
Parameter kedua adalah DatePickerDialog.OnDateSetListener, yang akan dipanggil ketika pengguna memilih tanggal.
calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), dan calendar.get(Calendar.DAY_OF_MONTH) digunakan untuk menetapkan nilai default berdasarkan tanggal saat ini.
Setelah pengguna memilih tanggal, tanggal yang dipilih akan ditampilkan di TextView (tvResult) dengan format dd/MM/yyyy


#### Penjelasan Kode Arelt

Import Library: Pastikan mengimpor AlertDialog dan Button.
onCreate(): Di sini kita menginisialisasi tombol dan menetapkan OnClickListener untuk menampilkan alert dialog.
showAlertDialog(): Fungsi ini membuat dan menampilkan alert dialog dengan dua tombol:
setPositiveButton(): Mengatur aksi ketika tombol "Yes" ditekan.
setNegativeButton(): Mengatur aksi ketika tombol "NO" ditekan.
dialog.dismiss(): Menutup dialog ketika salah satu tombol ditekan.

fungsi :
Fungsi alert dialog dalam aplikasi Android memiliki beberapa tujuan, antara lain:

1. Memberikan Informasi
Alert dialog dapat digunakan untuk menyampaikan informasi penting kepada pengguna, seperti peringatan atau notifikasi tentang suatu kondisi dalam aplikasi.

2. Meminta Konfirmasi
Dialog ini sering digunakan untuk meminta konfirmasi dari pengguna sebelum melakukan tindakan yang mungkin berisiko, seperti menghapus data atau keluar dari aplikasi. Misalnya, saat pengguna menekan tombol "Yes" atau "NO", aplikasi dapat menentukan tindakan yang akan diambil berdasarkan pilihan tersebut.

3. Menyediakan Opsi Pilihan
Alert dialog dapat menawarkan beberapa opsi kepada pengguna dalam bentuk tombol. Dalam contoh yang kita bahas, pengguna memiliki dua pilihan (tombol "Yes" dan "NO") untuk menentukan tindak lanjut tindakan yang diinginkan.

4. Meningkatkan Pengalaman Pengguna
Dengan menggunakan alert dialog, aplikasi dapat berinteraksi dengan pengguna secara lebih baik, memberikan umpan balik instan dan membuat aplikasi lebih responsif terhadap tindakan pengguna. 

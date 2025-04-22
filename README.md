# Penjelasan Projek E-Learning Input Control

## 1. DateTime (Pemilih Tanggal)
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

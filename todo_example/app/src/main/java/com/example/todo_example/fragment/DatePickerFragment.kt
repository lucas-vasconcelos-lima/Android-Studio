package com.example.todo_example.fragment

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.CalendarView
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

class DatePickerFragment (

    //dialog = abre a tela de calendario e pega a interface do onDateSetListener
    val timerPickerListener: TimerPickerListener
        ) : DialogFragment(), DatePickerDialog.OnDateSetListener {

    //criar os metodos necessarios para o calendario
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // atribui instancia de calendario para a variavel
        val c = Calendar.getInstance()
        // busca os atributos dentro da instancia
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // dialog pede contexto, onde e oq fazer
        return DatePickerDialog(requireContext(), this, year, month, day)
    }

    // atribui o atributo de calendar na sequencia de formação
    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, p1)
        calendar.set(Calendar.MONTH, p2)
        calendar.set(Calendar.DAY_OF_MONTH, p3)

        //quando for selecionada retorna em forma de local date
        timerPickerListener.onDateSelected(
            calendar.time.toInstant()

                .atZone(ZoneId.systemDefault()).toLocalDate()
        )
    }
// abrir interface e abrir o local date
} interface TimerPickerListener {
    fun onDateSelected(date: LocalDate)
}
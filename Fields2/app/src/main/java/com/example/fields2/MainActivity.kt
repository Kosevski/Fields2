package com.example.fields2

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var fields: Array<ImageView>? = null
    var player1turn: Boolean = true
    var roundCount: Int = 0
    var player1Count: Int = 0
    var player2Count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fields = arrayOf(
            findViewById(R.id.field_1),
            findViewById(R.id.field_2),
            findViewById(R.id.field_3),
            findViewById(R.id.field_4),
            findViewById(R.id.field_5),
            findViewById(R.id.field_6),
            findViewById(R.id.field_7),
            findViewById(R.id.field_8),
            findViewById(R.id.field_9),
            findViewById(R.id.field_10),
            findViewById(R.id.field_11),
            findViewById(R.id.field_12),
            findViewById(R.id.field_13),
            findViewById(R.id.field_14),
            findViewById(R.id.field_15),
            findViewById(R.id.field_16),
            findViewById(R.id.field_17),
            findViewById(R.id.field_18),
            findViewById(R.id.field_19),
            findViewById(R.id.field_20),
            findViewById(R.id.field_21),
            findViewById(R.id.field_22),
            findViewById(R.id.field_23),
            findViewById(R.id.field_24),
            findViewById(R.id.field_25)
        )

        findViewById<Button>(R.id.btn_reset).setOnClickListener {
            for (i in 0..24) {
                fields!![i].setBackgroundColor(getColor(R.color.fieldGray))
            }

            player1Count = 0
            player2Count = 0
            findViewById<TextView>(R.id.BlueFieldsCountTv).text = "0"
            findViewById<TextView>(R.id.RedFieldsCountTv).text = "0"
            findViewById<TextView>(R.id.winTV).text = ""
        }
    }

    var drawable: ColorDrawable? = null
    var drawable1: ColorDrawable? = null
    var drawable2: ColorDrawable? = null
    var drawable3: ColorDrawable? = null
    var drawable4: ColorDrawable? = null

    fun fieldClick(view: View) {
        val fieldsToTake: Array<Int>? = takeFields(getPosition(view))

        if (player1turn) {
            drawable = view.background as ColorDrawable?
            drawable1 = fieldsToTake?.get(1)?.let { fields?.get(it)?.background } as ColorDrawable?

            if (fieldsToTake?.size!! > 2) {
                drawable2 = fieldsToTake[2].let { fields?.get(it)?.background } as ColorDrawable?
                if (fieldsToTake.size > 3) {
                    drawable3 =
                        fieldsToTake[3].let { fields?.get(it)?.background } as ColorDrawable?
                    if (fieldsToTake.size > 4) {
                        drawable4 =
                            fieldsToTake[4].let { fields?.get(it)?.background } as ColorDrawable?
                    }
                }
            }

            if (drawable?.color == getColor(R.color.fieldGray)) {
                fieldsToTake.get(0)
                    .let { fields?.get(it)?.setBackgroundColor(getColor(R.color.red)) }
                player1Count++
                findViewById<TextView>(R.id.RedFieldsCountTv).text = player1Count.toString()

                when (drawable1?.color) {
                    getColor(R.color.fieldGray) -> fieldsToTake.get(1)
                        .let { fields?.get(it)?.setBackgroundColor(getColor(R.color.red_light)) }
                    getColor(R.color.blue_light) -> fieldsToTake.get(1)
                        .let { fields?.get(it)?.setBackgroundColor(getColor(R.color.fieldGray)) }
                }

                if (fieldsToTake.size > 2) {
                    when (drawable2?.color) {
                        getColor(R.color.fieldGray) -> fieldsToTake[2]
                            .let {
                                fields?.get(it)?.setBackgroundColor(getColor(R.color.red_light))
                            }
                        getColor(R.color.blue_light) -> fieldsToTake[2]
                            .let {
                                fields?.get(it)?.setBackgroundColor(getColor(R.color.fieldGray))
                            }
                    }
                    if (fieldsToTake.size > 3) {
                        when (drawable3?.color) {
                            getColor(R.color.fieldGray) -> fieldsToTake[3]
                                .let {
                                    fields?.get(it)?.setBackgroundColor(getColor(R.color.red_light))
                                }
                            getColor(R.color.blue_light) -> fieldsToTake[3]
                                .let {
                                    fields?.get(it)?.setBackgroundColor(getColor(R.color.fieldGray))
                                }
                        }
                        if (fieldsToTake.size > 4) {
                            when (drawable4?.color) {
                                getColor(R.color.fieldGray) -> fieldsToTake[4]
                                    .let {
                                        fields?.get(it)
                                            ?.setBackgroundColor(getColor(R.color.red_light))
                                    }
                                getColor(R.color.blue_light) -> fieldsToTake[4]
                                    .let {
                                        fields?.get(it)
                                            ?.setBackgroundColor(getColor(R.color.fieldGray))
                                    }
                            }
                        }
                    }
                }
            }
        } else {
            drawable = view.background as ColorDrawable?
            drawable1 = fieldsToTake?.get(1)?.let { fields?.get(it)?.background } as ColorDrawable?

            if (fieldsToTake?.size!! > 2) {
                drawable2 = fieldsToTake[2].let { fields?.get(it)?.background } as ColorDrawable?
                if (fieldsToTake.size > 3) {
                    drawable3 =
                        fieldsToTake[3].let { fields?.get(it)?.background } as ColorDrawable?
                    if (fieldsToTake.size > 4) {
                        drawable4 =
                            fieldsToTake[4].let { fields?.get(it)?.background } as ColorDrawable?
                    }
                }
            }

            if (drawable?.color == getColor(R.color.fieldGray)) {
                fieldsToTake.get(0)
                    .let { fields?.get(it)?.setBackgroundColor(getColor(R.color.blue)) }
                player2Count++
                findViewById<TextView>(R.id.BlueFieldsCountTv).text = player2Count.toString()

                when (drawable1?.color) {
                    getColor(R.color.fieldGray) -> fieldsToTake.get(1)
                        .let { fields?.get(it)?.setBackgroundColor(getColor(R.color.blue_light)) }
                    getColor(R.color.red_light) -> fieldsToTake.get(1)
                        .let { fields?.get(it)?.setBackgroundColor(getColor(R.color.fieldGray)) }
                }

                if (fieldsToTake.size > 2) {
                    when (drawable2?.color) {
                        getColor(R.color.fieldGray) -> fieldsToTake[2]
                            .let {
                                fields?.get(it)?.setBackgroundColor(getColor(R.color.blue_light))
                            }
                        getColor(R.color.red_light) -> fieldsToTake[2]
                            .let {
                                fields?.get(it)?.setBackgroundColor(getColor(R.color.fieldGray))
                            }
                    }
                    if (fieldsToTake.size > 3) {
                        when (drawable3?.color) {
                            getColor(R.color.fieldGray) -> fieldsToTake[3]
                                .let {
                                    fields?.get(it)
                                        ?.setBackgroundColor(getColor(R.color.blue_light))
                                }
                            getColor(R.color.red_light) -> fieldsToTake[3]
                                .let {
                                    fields?.get(it)?.setBackgroundColor(getColor(R.color.fieldGray))
                                }
                        }
                        if (fieldsToTake.size > 4) {
                            when (drawable4?.color) {
                                getColor(R.color.fieldGray) -> fieldsToTake[4]
                                    .let {
                                        fields?.get(it)
                                            ?.setBackgroundColor(getColor(R.color.blue_light))
                                    }
                                getColor(R.color.red_light) -> fieldsToTake[4]
                                    .let {
                                        fields?.get(it)
                                            ?.setBackgroundColor(getColor(R.color.fieldGray))
                                    }
                            }
                        }
                    }
                }
            }
        }
        roundCount++
        if (roundCount != 1000) {
            player1turn = !player1turn
        }
        checkForWin()

    }

    private fun getPosition(view: View): Int {
        for (i in 0..24) {
            if (view.id == fields?.get(i)?.id) {
                return i
            }
        }
        return 0
    }

    private fun takeFields(i: Int): Array<Int>? {
        var positionsForField: Array<Int>? = null
        when (i) {
            0 -> positionsForField = arrayOf(i, i + 1, i + 5)
            24 -> positionsForField = arrayOf(i, i - 1, i - 5)
            4 -> positionsForField = arrayOf(i, i - 1, i + 5)
            20 -> positionsForField = arrayOf(i, i + 1, i - 5)
            1, 2, 3 -> positionsForField = arrayOf(i, i + 1, i - 1, i + 5)
            21, 22, 23 -> positionsForField = arrayOf(i, i + 1, i - 1, i - 5)
            6, 7, 8 -> positionsForField = arrayOf(i, i + 1, i - 1, i - 5, i + 5)
            11, 12, 13 -> positionsForField = arrayOf(i, i + 1, i - 1, i - 5, i + 5)
            16, 17, 18 -> positionsForField = arrayOf(i, i + 1, i - 1, i - 5, i + 5)
            5, 10, 15 -> positionsForField = arrayOf(i, i + 1, i - 5, i + 5)
            9, 14, 19 -> positionsForField = arrayOf(i, i - 1, i - 5, i + 5)
        }
        return positionsForField
    }

    private fun checkForWin() {
        var emptyFields = 25
        for (i in 0..24) {
            val drawable: ColorDrawable? =
                fields?.get(i)?.background as ColorDrawable?
            if (drawable?.color != getColor(R.color.fieldGray)) {
                emptyFields--
                when (emptyFields) {
                    0 -> findViewById<TextView>(R.id.winTV).text = whoWins()
                }
            }
        }
    }

    private fun whoWins(): String {
        var whoWins: String? = null
        if (player1Count > player2Count) {
            whoWins = "Player Red Wins"
        } else if (player1Count == player2Count) {
            whoWins = "Draw"
        } else {
            whoWins = "Player Blue Wins"
        }
        return whoWins
    }
}



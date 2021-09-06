package com.movie.cashmachine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.movie.cashmachine.ui.theme.CashMachineTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CashMachineTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val uiCardMachineDetailsItemEntity =
                        listOf(
                            UiMachineNameEntity(
                                name = "Card 1",
                                "2000000000000000000000000000",
                                "Card 1 description"
                            ),
                            UiSerialNumberEntity("Serial", "1111", null),
                            UiSerialNumberEntity("Model", "1111", null),
                            UiMachineNameEntity(
                                name = "Card 1",
                                "2000",
                                "Card 1 description"
                            ),
                            UiSerialNumberEntity("Serial", "1111", null),
                            
                            )

                    showCardMachineDetails(uiCardMachineDetailsItemEntityList = uiCardMachineDetailsItemEntity)
                }
            }
        }
    }

}

@Composable
private fun showCardMachineDetails(
    uiCardMachineDetailsItemEntityList: List<UiCardMachineDetailsItemEntity>
) {
    LazyColumn {
        items(uiCardMachineDetailsItemEntityList) {
            if (it is UiMachineNameEntity) {
                ThreeLineListItemsWithIcon(
                    textTop = it.name,
                    textCenter = it.value,
                    icon = {
                        Icon(
                            Icons.Filled.Edit,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .background(Color.Red)
                                .clickable { print("Item has been clicked") }
                        )
                    },
                    textBottom = it.description,
                    itemClickListener = null,

                    )
            } else {
                ThreeLineListItemsWithoutIcon(textTop = it.name, textCenter = it.value)
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun ThreeLineListItemsWithIcon(
    modifier: Modifier = Modifier,
    textTop: String,
    textCenter: String,
    textBottom: String? = null,
    icon: @Composable (() -> Unit)? = null,
    itemClickListener: (() -> Unit)? = null,
) {
    Surface(color = MaterialTheme.colors.surface) {
        Column {
            ListItem(
                overlineText = {
                    Text(
                        textTop,
                        fontSize = 14.sp,
                        color = Color.Red
                    )
                },
                text = {
                    Text(
                        textCenter,
                        fontSize = 16.sp,
                        color = Color.Black,
                    )
                }, secondaryText = {
                    if (textBottom != null) {
                        Text(
                            textBottom,
                            fontSize = 14.sp,
                            color = Color.Red
                        )
                    }
                },
                modifier = modifier.clickable { itemClickListener?.invoke() },
                trailing = icon
            )
        }
    }
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun ThreeLineListItemsWithoutIcon(
    textTop: String,
    textCenter: String,
) {
    Column {
        ListItem(
            overlineText = {
                Text(
                    textTop,
                    fontSize = 14.sp,
                    color = Color.Red
                )
            },
            text = {
                Text(
                    textCenter,
                    fontSize = 16.sp,
                    color = Color.Black,

                    )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CashMachineTheme {

        val uiCardMachineDetailsItemEntity =
            listOf(
                UiMachineNameEntity(name = "Card 1", "2000", "Card 1 description"),
                UiMachineNameEntity(name = "Card 2", "30000", " Card 2 Description")
            )
        showCardMachineDetails(uiCardMachineDetailsItemEntityList = uiCardMachineDetailsItemEntity)
    }
}
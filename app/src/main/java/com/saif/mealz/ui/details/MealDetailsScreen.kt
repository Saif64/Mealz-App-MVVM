package com.saif.mealz.ui.details

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.saif.mealz.ui.model.response.MealResponse
import kotlin.math.min

@Composable
fun MealDetailScreen(meal: MealResponse?) {
    val profilePictureState by remember { mutableStateOf(MealProfilePictureState.Normal) }
    val transition = updateTransition(targetState = profilePictureState, label = "")
    val color by transition.animateColor(targetValueByState = { it.color }, label = "")
    val scrollState = rememberLazyListState()
    val offset = min(
        1f,
        1 - (scrollState.firstVisibleItemScrollOffset / 600f
                + scrollState.firstVisibleItemIndex)
    )
    val size by animateDpAsState(targetValue = max(100.dp, 140.dp * offset))


    Surface(color = MaterialTheme.colors.background) {
        Column {
            Surface(elevation = 2.dp) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Card(
                        modifier = Modifier.padding(16.dp),
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 2.dp,
                            color = color
                        )
                    ) {
                        Image(
                            painter = rememberImagePainter(data = meal?.imageUrl,
                                builder = {
                                    transformations(CircleCropTransformation())
                                }),
                            contentDescription = null,
                            modifier = Modifier
                                .size(size)
                                .padding(6.dp)
                        )
                    }
                    Text(
                        text = meal?.name ?: "default name",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterVertically),
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp
                    )
                }
            }
            Text(
                text = meal?.description ?: "",
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally),
                fontSize = 18.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}


enum class MealProfilePictureState(val color: Color) {
    Normal(Color.Magenta),
}
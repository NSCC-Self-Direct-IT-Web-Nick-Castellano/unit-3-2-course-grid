package com.example.unit_3_2_build_a_grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unit_3_2_build_a_grid.ui.theme.Unit32buildagridTheme

// import data and model
import com.example.unit_3_2_build_a_grid.data.DataSource
import com.example.unit_3_2_build_a_grid.model.Topic

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Unit32buildagridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseTopicsApp()
                }
            }
        }
    }
}

@Composable
fun CourseTopicsApp(
    modifier: Modifier = Modifier
) {
    CourseGrid(DataSource)
}

@Composable
fun CourseGrid(
    dataSource: DataSource,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 140.dp)
    ) {
        items(dataSource.topics) { course ->
            CourseCard(course)
        }
    }
}

@Composable
fun CourseCard(
    topic: Topic,
    modifier: Modifier = Modifier
) {
    Card (

        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),

    ) {
        Row (
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
        ) {
            Image(
                painter =
                painterResource(id = topic.courseImage),
                contentDescription =
                stringResource(id = topic.courseTopic)
            )
            Column (
                modifier = Modifier
                    .padding(2.dp)
            ) {

                Text(
                    text = stringResource(id = topic.courseTopic),
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(12.dp, 0.dp, 0.dp, 0.dp)
                    )
                Row (
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(12.dp, 0.dp, 0.dp, 0.dp)
                ) {
                    Icon(painter = painterResource(
                        id = R.drawable.ic_grain),
                        contentDescription = "Topic Icon"
                    )
                    Text(
                        text = topic.numberOfCourses.toString(),
                        modifier = Modifier
                            .padding(4.dp, 0.dp, 0.dp, 0.dp)
                        )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CourseGrid(DataSource)
}
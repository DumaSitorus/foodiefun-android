package com.duma.foodiefun

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.duma.foodiefun.ui.component.TopBar
import com.duma.foodiefun.ui.component.TopBarAddForm
import com.duma.foodiefun.ui.component.TopBarDetail
import com.duma.foodiefun.ui.component.TopBarInfo
import com.duma.foodiefun.ui.component.TopBarProfile
import com.duma.foodiefun.ui.navigation.NavigationItem
import com.duma.foodiefun.ui.navigation.Screen
import com.duma.foodiefun.ui.screen.add.AddScreen
import com.duma.foodiefun.ui.screen.detail.DetailScreen
import com.duma.foodiefun.ui.screen.favorite.FavoriteScreen
import com.duma.foodiefun.ui.screen.home.HomeScreen
import com.duma.foodiefun.ui.screen.info.InfoScreen
import com.duma.foodiefun.ui.screen.profile.ProfileScreen
import com.duma.foodiefun.ui.theme.FoodieFunTheme

@Composable
fun FoodieFunApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        topBar = {
            when (currentRoute) {
                Screen.Home.route, Screen.Favorite.route -> {
                    TopBar(onProfileClick = { navController.navigate("profile") })
                }

                Screen.Profile.route -> {
                    TopBarProfile(
                        onBackClick = { navController.popBackStack() },
                        onInfoClick = { navController.navigate("info") }
                    )
                }

                Screen.Detail.route -> {
                    TopBarDetail(
                        onBackClick = { navController.popBackStack() },
                        onInfoClick = { navController.navigate("info") }
                    )
                }

                Screen.Add.route -> {
                    TopBarAddForm(
                        onBackClick = { navController.popBackStack() },
                        onInfoClick = { navController.navigate("info") }
                    )
                }

                else -> {
                    TopBarInfo(
                        onBackClick = { navController.popBackStack() },
                        onInfoClick = { navController.navigate("info") }
                    )
                }
            }
        },

        bottomBar = {
            if (currentRoute == Screen.Home.route || currentRoute == Screen.Favorite.route) {
                BottomBar(navController)
            }
        },
        floatingActionButton = {
            if (currentRoute == Screen.Home.route) {
                FloatingActionButton(
                    onClick = { navController.navigate("add")},
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                }
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = { foodId ->
                        navController.navigate(Screen.Detail.createRoute(foodId))
                    }
                )
            }
            composable(Screen.Favorite.route) {
                FavoriteScreen(
                    navigateToDetail = { foodId ->
                        navController.navigate(Screen.Detail.createRoute(foodId))
                    }
                )
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
            composable(Screen.Info.route) {
                InfoScreen()
            }
            composable(Screen.Add.route) {
                AddScreen(navController = navController)
            }
            composable(
                route = Screen.Detail.route,
                arguments = listOf(navArgument("foodId") { type = NavType.LongType }),
            ) {
                val id = it.arguments?.getLong("foodId") ?: -1L
                DetailScreen(
                    foodId = id,
                    navigateBack = {
                        navController.navigateUp()
                    },
                )
            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(R.string.menu_favorite),
                icon = Icons.Default.Favorite,
                screen = Screen.Favorite
            ),
        )
        navigationItems.map { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                    )
                },
                label = { Text(item.title) },
                selected = currentRoute == item.screen.route,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    indicatorColor = MaterialTheme.colorScheme.secondary
                ),
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JetHeroesAppPreview() {
    FoodieFunTheme {
        FoodieFunApp()
    }
}


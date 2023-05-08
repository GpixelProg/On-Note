package gpixel.prog.note.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import gpixel.prog.note.MainRes
import gpixel.prog.note.features.components.squircle.SquircleTextField
import gpixel.prog.note.orangeColor
import gpixel.prog.note.platform.getTopPadding
import gpixel.prog.note.view_models.CreateAccountModel
import io.github.skeptick.libres.compose.painterResource

/**
 * TODO Ime Action on iOS is not working yet but
 * working other features like keyboard type '\n'
 */
fun returnImeAction(value: MutableState<String>, content: () -> Unit) {
    if (value.value.last() == '\n') {
        value.value = value.value.dropLast(1)
        content()
    }
}

object CreateAccount : Screen {
    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    override fun Content() {
        val createAccountModel = rememberScreenModel { CreateAccountModel() }
        val keyController = LocalSoftwareKeyboardController.current
        val focusManager = LocalFocusManager.current

        Column(modifier = Modifier
            .verticalScroll(rememberScrollState())
            .pointerInput(Unit) {
                detectTapGestures {
                    keyController?.hide()
                }
            }
        ) {
            Image(
                painter = painterResource(image = MainRes.image.logo),
                contentDescription = null,
                modifier = Modifier.padding(top = 0.dp)
            )

            Text(
                text = "Create Account.",
                modifier = Modifier
                    .padding(top = 15.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                fontSize = 24.sp,
                color = Color.White,
            )

            Row(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .align(alignment = Alignment.CenterHorizontally),
            ) {
                Text(
                    text = "Don't have an account?",
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.5f),
                )

                Text(
                    text = "Sign In",
                    modifier = Modifier
                        .clickable {  }
                        .padding(start = 5.dp),
                    fontSize = 14.sp,
                    color = orangeColor,
                )
            }

            Column(modifier = Modifier.padding(top = 20.dp)) {
                Text(
                    text = "Email",
                    modifier = Modifier.padding(start = 20.dp),
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.7f),
                )

                SquircleTextField(
                    value = createAccountModel.email.value,
                    onValueChange = {
                        createAccountModel.email.value = it
                        returnImeAction(createAccountModel.email) {
                            focusManager.moveFocus(FocusDirection.Next)
                        }
                    },
                    placeholderText = "Enter your email",
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(horizontal = 20.dp)
                        .height(40.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Next) }
                    )
                )

                Text(
                    text = "Password",
                    modifier = Modifier.padding(top = 15.dp, start = 20.dp),
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.7f),
                )

                SquircleTextField(
                    value = createAccountModel.password.value,
                    onValueChange = { createAccountModel.password.value = it },
                    placeholderText = "Enter your password",
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(horizontal = 20.dp)
                        .height(40.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Next) }
                    ),
                    visualTransformation = PasswordVisualTransformation()
                )

                Text(
                    text = "Confirm Password",
                    modifier = Modifier.padding(top = 15.dp, start = 20.dp),
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.7f),
                )

                SquircleTextField(
                    value = createAccountModel.confirmPassword.value,
                    onValueChange = { createAccountModel.confirmPassword.value = it },
                    placeholderText = "Confirm your password",
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(horizontal = 20.dp)
                        .height(40.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {  }
                    ),
                    visualTransformation = PasswordVisualTransformation()
                )

                Button(
                    onClick = {  },
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .height(40.dp)
                        .fillMaxWidth().padding(horizontal = 20.dp)
                        .align(alignment = Alignment.CenterHorizontally)
                        .shadow(4.dp, RoundedCornerShape(50)),
                    shape = RoundedCornerShape(percent = 50),
                    colors = ButtonDefaults.buttonColors(backgroundColor = orangeColor),
                ) {
                    Text(
                        text = "Create Account",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                    )
                }
            }
        }
    }
}
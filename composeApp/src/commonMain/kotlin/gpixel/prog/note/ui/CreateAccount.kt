package gpixel.prog.note.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
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
import cafe.adriel.voyager.core.stack.popUntil
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import gpixel.prog.note.MainRes
import gpixel.prog.note.ui.components.squircle.SquircleTextField
import gpixel.prog.note.orangeColor
import gpixel.prog.note.ui.components.returnImeAction
import gpixel.prog.note.view_models.CreateAccountModel
import io.github.skeptick.libres.compose.painterResource

object CreateAccount : Screen {
    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val createAccountModel = rememberScreenModel { CreateAccountModel(navigator) }
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
                        .clickable { createAccountModel.onLogin() }
                        .padding(start = 5.dp),
                    fontSize = 14.sp,
                    color = orangeColor,
                )
            }

            //Error message
            if (createAccountModel.errorMsg.isNotEmpty()) {
                Text(
                    text = createAccountModel.errorMsg,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .align(alignment = Alignment.CenterHorizontally),
                    fontSize = 14.sp,
                    color = Color.Red,
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
                    onValueChange = {
                        createAccountModel.password.value = it
                        returnImeAction(createAccountModel.password) {
                            focusManager.moveFocus(FocusDirection.Next)
                        }
                    },
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
                    onValueChange = {
                        createAccountModel.confirmPassword.value = it
                        returnImeAction(createAccountModel.confirmPassword) {
                            keyController?.hide()
                            createAccountModel.createAccount()
                        }
                    },
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
                        onNext = { createAccountModel.createAccount() }
                    ),
                    visualTransformation = PasswordVisualTransformation()
                )

                Button(
                    onClick = { createAccountModel.createAccount() },
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
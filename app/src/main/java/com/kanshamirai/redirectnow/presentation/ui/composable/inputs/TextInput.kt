package com.kanshamirai.presentation.ui.composable.inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.kanshamirai.presentation.ui.theme.ExtendedTheme
import com.kanshamirai.presentation.ui.theme.jakartaFontFamily
import com.kanshamirai.redirectnow.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput(
    modifier: Modifier,
    value: String = "",
    onValueChange: (String) -> Unit,
    isEnabled: Boolean = true,
    singleLine: Boolean = true,
    isError: Boolean = false,
    maxLines: Int = 1,
    label: String? = null,
    errorText: String? = null,
    endIcon: Int? = null,
    readOnly: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
    keyboardActions: KeyboardActions = KeyboardActions(),
    maxCharacters: Int? = null,
    onFocus: () -> Unit = {},
    onUnfocus: () -> Unit = {},
) {

    var text by rememberSaveable { mutableStateOf("") }
    val myFocusRequester = remember { FocusRequester() }

    TextField(
        modifier = modifier
            .focusRequester(myFocusRequester)
            .onFocusChanged {
                if (it.isFocused) {
                    onFocus()
                } else {
                    onUnfocus()
                }
            },
        value = value,
        onValueChange = { actualText ->
            if (maxCharacters != null) {
                if (actualText.length < maxCharacters) {
                    text = actualText
                    onValueChange(actualText)
                }
            } else {
                text = actualText
                onValueChange(actualText)
            }
        },
        singleLine = singleLine,
        isError = isError,
        enabled = isEnabled,
        readOnly = readOnly,
        textStyle = ExtendedTheme.typography.medium16,
        maxLines = maxLines,
        label = {
            label?.let {
                Text(
                    fontFamily = jakartaFontFamily,
                    text = it
                )
            }
        },
        supportingText = {
            errorText?.let {
                Text(
                    style = ExtendedTheme.typography.medium12,
                    text = it
                )
            }
        },
        trailingIcon = {
            endIcon?.let {
                Icon(painter = painterResource(id = endIcon), contentDescription = "")
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = ExtendedTheme.colors.white,
            cursorColor = ExtendedTheme.colors.darkBlue,
            disabledIndicatorColor = ExtendedTheme.colors.grayScale700,
            disabledLabelColor = ExtendedTheme.colors.grayScale700,
            disabledSupportingTextColor = ExtendedTheme.colors.grayScale700,
            disabledTextColor = ExtendedTheme.colors.grayScale700,
            disabledLeadingIconColor = ExtendedTheme.colors.grayScale700,
            disabledPlaceholderColor = ExtendedTheme.colors.grayScale700,
            disabledTrailingIconColor = ExtendedTheme.colors.grayScale700,
            errorContainerColor = ExtendedTheme.colors.white,
            errorCursorColor = ExtendedTheme.colors.red,
            errorIndicatorColor = ExtendedTheme.colors.red,
            errorTextColor = ExtendedTheme.colors.blackGrayScale,
            errorLabelColor = ExtendedTheme.colors.red,
            errorSupportingTextColor = ExtendedTheme.colors.red,
            errorLeadingIconColor = ExtendedTheme.colors.red,
            errorTrailingIconColor = ExtendedTheme.colors.red,
            focusedIndicatorColor = ExtendedTheme.colors.darkBlue,
            focusedLabelColor = ExtendedTheme.colors.darkBlue,
            focusedTextColor = ExtendedTheme.colors.blackGrayScale,
            focusedSupportingTextColor = ExtendedTheme.colors.darkBlue,
            focusedLeadingIconColor = ExtendedTheme.colors.darkBlue,
            focusedTrailingIconColor = ExtendedTheme.colors.darkBlue,
            unfocusedIndicatorColor = ExtendedTheme.colors.grayScale700,
            unfocusedTextColor = ExtendedTheme.colors.grayScale700,
            unfocusedLabelColor = ExtendedTheme.colors.grayScale700,
            unfocusedLeadingIconColor = ExtendedTheme.colors.grayScale700,
            unfocusedSupportingTextColor = ExtendedTheme.colors.grayScale700,
            unfocusedTrailingIconColor = ExtendedTheme.colors.grayScale700,
        ),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions
    )
}

/* Ative o modo interativo para ver melhor o funcionamento dos campos */
@Preview("Campo de texto padrão")
@Composable
fun TextInputPreview() {
    ExtendedTheme {
        TextInput(
            modifier = Modifier.fillMaxWidth(),
            value = "Text",
            onValueChange = {},
            label = "Label"
        )
    }
}

@Preview("Campo de texto padrão sem Label")
@Composable
fun TextInputPreviewNoLabel() {
    ExtendedTheme {
        TextInput(
            modifier = Modifier.fillMaxWidth(),
            value = "Text",
            onValueChange = {},
        )
    }
}


@Preview("Campo de texto com erro")
@Composable
fun TextInputPreviewWithError() {
    ExtendedTheme {
        TextInput(
            modifier = Modifier.fillMaxWidth(),
            value = "Text",
            onValueChange = {},
            label = "Label",
            isError = true,
            errorText = "*Error message"
        )
    }
}

@Preview("Campo de texto desabilitado")
@Composable
fun TextInputPreviewDisabled() {
    ExtendedTheme {
        TextInput(
            modifier = Modifier.fillMaxWidth(),
            value = "Text",
            onValueChange = {},
            label = "Label",
            isEnabled = false,
            endIcon = R.drawable.ic_lock
        )
    }
}
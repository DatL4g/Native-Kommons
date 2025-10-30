package dev.datlag.kommons


data object Vanuatu : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("VU")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("VUT")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(548)
}
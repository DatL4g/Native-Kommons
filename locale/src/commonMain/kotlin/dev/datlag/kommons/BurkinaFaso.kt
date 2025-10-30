package dev.datlag.kommons


data object BurkinaFaso : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("BF")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("BFA")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(854)
}
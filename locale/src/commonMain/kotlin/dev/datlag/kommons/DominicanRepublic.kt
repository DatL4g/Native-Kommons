package dev.datlag.kommons


data object DominicanRepublic : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("DO")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("DOM")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(214)
}
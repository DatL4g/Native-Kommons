package dev.datlag.kommons


data object SaoTomeAndPrincipe : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("ST")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("STP")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(678)
}
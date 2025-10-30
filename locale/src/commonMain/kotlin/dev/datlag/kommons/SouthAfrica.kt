package dev.datlag.kommons


data object SouthAfrica : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("ZA")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("ZAF")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(710)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(27)
}
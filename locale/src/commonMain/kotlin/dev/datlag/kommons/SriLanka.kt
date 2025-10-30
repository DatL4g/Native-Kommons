package dev.datlag.kommons


data object SriLanka : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("LK")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("LKA")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(144)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(94)
}
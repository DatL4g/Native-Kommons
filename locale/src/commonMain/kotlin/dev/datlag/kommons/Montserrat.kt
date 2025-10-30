package dev.datlag.kommons


data object Montserrat : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("MS")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("MSR")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(500)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(1664)
}
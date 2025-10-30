package dev.datlag.kommons


data object Georgia : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("GE")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("GEO")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(268)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(995)
}
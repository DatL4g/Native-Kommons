package dev.datlag.kommons


data object Greenland : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("GL")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("GRL")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(304)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(299)
}
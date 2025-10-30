package dev.datlag.kommons


data object Tajikistan : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("TJ")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("TJK")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(762)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(992)
}
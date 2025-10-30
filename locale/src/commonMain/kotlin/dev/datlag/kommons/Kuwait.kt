package dev.datlag.kommons


data object Kuwait : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("KW")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("KWT")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(414)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(965)
}
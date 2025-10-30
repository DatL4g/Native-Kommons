package dev.datlag.kommons


data object Bermuda : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("BM")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("BMU")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(60)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(1441)
}